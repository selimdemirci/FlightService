package com.demo.flightservice.service;

import com.demo.flightservice.dto.ticket.ReservationDTO;
import com.demo.flightservice.dto.ticket.TicketDTO;

public interface TicketService {

    boolean cancelReservation(long id);
    TicketDTO reservation(ReservationDTO reservation);
    TicketDTO findTicketById(long id);
}