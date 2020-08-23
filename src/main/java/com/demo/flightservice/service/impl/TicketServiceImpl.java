package com.demo.flightservice.service.impl;

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
import com.demo.flightservice.util.RoundNumber;
import com.demo.flightservice.util.converter.TicketToTicketDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private final PassengerService passengerService;
    private final TicketToTicketDTO ticketToTicketDTOConverter;
    private final RoundNumber roundNumber;


    public TicketServiceImpl(TicketRepository ticketRepository, FlightService flightService, PassengerService passengerService,
        TicketToTicketDTO ticketToTicketDTOConverter, RoundNumber roundNumber) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
        this.passengerService = passengerService;
        this.ticketToTicketDTOConverter = ticketToTicketDTOConverter;
        this.roundNumber = roundNumber;
    }


    @Override
    public ReservationDTO cancelReservation(long id) {
        Ticket ticket = ticketRepository.findById(id).get();
        Flight flight = flightService.findById(ticket.getFlight().getId());
        Passenger passenger = passengerService.findById(ticket.getPassenger().getId());

        ticket.setTicketStatus(TicketStatus.CANCELLED);

        flight.setBookedSeatsCount(flight.getBookedSeatsCount() - 1);
        setExtraPriceCoefficient(flight);

        passenger.setBudget(passenger.getBudget() + ticket.getPrice());

        ticketRepository.save(ticket);
        flightService.save(flight);
        passengerService.save(passenger);

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setFlightId(flight.getId());
        reservationDTO.setPassengerId(passenger.getId());

        return reservationDTO;
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
        ticket.setSeat(Integer.toString(flight.getBookedSeatsCount() + 1));
        ticket.setTicketStatus(TicketStatus.PROCEED);

        flight.setBookedSeatsCount(flight.getBookedSeatsCount() + 1);
        setTicketPriceAndExtraPriceCoefficient(ticket, flight);
        
        double currentBudget = passenger.getBudget() - ticket.getPrice();
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

    @Override
    public String deleteReservation(long id) {
        Ticket ticket = ticketRepository.findById(id).get();
        if(ticket.getTicketStatus() == TicketStatus.CANCELLED){
            ticketRepository.deleteById(id);
            return "Ticket number " + id + " has been deleted.";
        }else{
            return "Ticket number " + id + " can not delete. Firstly, you have to update ticket status as 'CANCELLED'.";
        }
    }

    @Override
    public void setTicketPriceAndExtraPriceCoefficient(Ticket ticket, Flight flight) {
        double extraPriceCoefficient = roundNumber.roundPercentage(flight.getBookedSeatsCount(), flight.getTotalSeatsCount()) / 10;
        double price = flight.getPrice();
        price += (price * extraPriceCoefficient);

        ticket.setPrice(price);
        flight.setExtraPriceCoefficient(extraPriceCoefficient);
    }

    @Override
    public void setExtraPriceCoefficient(Flight flight) {
        double extraPriceCoefficient = roundNumber.roundPercentage(flight.getBookedSeatsCount(), flight.getTotalSeatsCount()) / 10;
        flight.setExtraPriceCoefficient(extraPriceCoefficient);
    }

    
}