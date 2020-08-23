package com.demo.flightservice.service;

import com.demo.flightservice.dto.ticket.ReservationDTO;
import com.demo.flightservice.dto.ticket.TicketDTO;

public interface TicketService {

    double setTicketPrice(int oldSeatCount, int currentSeatCount, int totalSeatCount);

    String deleteReservation(long id);

    ReservationDTO cancelReservation(long id);

    TicketDTO findTicketById(long id);
    TicketDTO reservation(ReservationDTO reservation);
}