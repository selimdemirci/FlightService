package com.demo.flightservice.service;

import com.demo.flightservice.dto.ticket.ReservationDTO;
import com.demo.flightservice.dto.ticket.TicketDTO;
import com.demo.flightservice.model.Flight;
import com.demo.flightservice.model.Ticket;

public interface TicketService {

    void setTicketPriceAndExtraPriceCoefficient(Ticket ticket, Flight flight);
    void setExtraPriceCoefficient(Flight flight);
    
    ReservationDTO deleteReservation(long id);
    ReservationDTO cancelReservation(long id);

    TicketDTO findTicketById(long id);
    TicketDTO reservation(ReservationDTO reservation);
}