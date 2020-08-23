package com.demo.flightservice.util.converter;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.dto.ticket.TicketDTO;
import com.demo.flightservice.model.Flight;
import com.demo.flightservice.model.Passenger;
import com.demo.flightservice.model.Ticket;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketToTicketDTO {

    private final ModelMapper modelMapper;

    public TicketToTicketDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TicketDTO convert(Ticket ticket, Flight flight, Passenger passenger){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setBookingDate(ticket.getBookingDate());
        ticketDTO.setPrice(ticket.getPrice());
        ticketDTO.setSeat(ticket.getSeat());  
        ticketDTO.setTicketStatus(ticket.getTicketStatus());
        ticketDTO.setCompanyName(flight.getCompany().getName());
        ticketDTO.setDepartureTime(flight.getDepartureTime());
        ticketDTO.setDestination(modelMapper.map(flight.getRoute().getDestination(), AirportDTO.class));
        ticketDTO.setFrom(modelMapper.map(flight.getRoute().getFrom(), AirportDTO.class));
        ticketDTO.setName(passenger.getName());
        ticketDTO.setSurname(passenger.getSurname());

        return ticketDTO;
    }
    
}