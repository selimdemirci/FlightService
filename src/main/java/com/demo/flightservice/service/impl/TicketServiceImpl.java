package com.demo.flightservice.service.impl;

import java.util.List;

import com.demo.flightservice.dto.ticket.ReservationDTO;
import com.demo.flightservice.dto.ticket.TicketDTO;
import com.demo.flightservice.enums.TicketStatus;
import com.demo.flightservice.exception.TicketException;
import com.demo.flightservice.model.Flight;
import com.demo.flightservice.model.Passenger;
import com.demo.flightservice.model.Ticket;
import com.demo.flightservice.repository.TicketRepository;
import com.demo.flightservice.service.FlightService;
import com.demo.flightservice.service.PassengerService;
import com.demo.flightservice.service.TicketService;
import com.demo.flightservice.util.converter.TicketToTicketDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private final PassengerService passengerService;
    private final ModelMapper modelMapper;
    private final TicketToTicketDTO ticketToTicketDTOConverter;


    public TicketServiceImpl(TicketRepository ticketRepository, FlightService flightService, PassengerService passengerService, ModelMapper modelMapper,
    TicketToTicketDTO ticketToTicketDTOConverter) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
        this.passengerService = passengerService;
        this.modelMapper = modelMapper;
        this.ticketToTicketDTOConverter = ticketToTicketDTOConverter;
    }


    @Override
    public boolean cancelReservation(long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public TicketDTO reservation(ReservationDTO reservation) {
        Flight flight = flightService.findById(reservation.getFlightId());
        Passenger passenger = passengerService.findById(reservation.getPassengerId());

        if(flight == null || passenger == null){
            throw new TicketException("Flight or passenger does not exist.");
        }else if(flight.getBookedSeatsCount() == flight.getTotalSeatsCount()){
            throw new TicketException("Seats all booked!");
        }else if(passenger.getBudget() < flight.getPrice()){
            throw new TicketException("Insufficient budget.");
        }

        Ticket ticket = new Ticket();
        ticket.setFlight(flight);
        ticket.setPassenger(passenger);
        ticket.setPrice(flight.getPrice());
        ticket.setSeat(Integer.toString(flight.getBookedSeatsCount() + 1));
        ticket.setTicketStatus(TicketStatus.PROCEED);

        flight.setBookedSeatsCount(flight.getBookedSeatsCount() + 1);

        double currentBudget = passenger.getBudget() - flight.getPrice();
        passenger.setBudget(currentBudget);

        ticketRepository.save(ticket);
        flightService.save(flight);
        passengerService.save(passenger);

        return ticketToTicketDTOConverter.convert(ticket, flight, passenger);
    }

    @Override
    public TicketDTO findTicketById(long id) {
        Ticket ticket = ticketRepository.findById(id).get();
        Flight flight = flightService.findById(ticket.getFlight().getId());
        Passenger passenger = passengerService.findById(ticket.getPassenger().getId());

        return ticketToTicketDTOConverter.convert(ticket, flight, passenger);
    }
    
}