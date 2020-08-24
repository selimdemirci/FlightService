package com.demo.flightservice.controller;

import com.demo.flightservice.dto.ticket.ReservationDTO;
import com.demo.flightservice.dto.ticket.TicketDTO;
import com.demo.flightservice.service.TicketService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value="/reservation", produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity<TicketDTO> reservation(@Validated @RequestBody ReservationDTO reservation) {
        return new ResponseEntity<>(ticketService.reservation(reservation), HttpStatus.CREATED);
    }

    
    @GetMapping(value="/find", produces = "application/json")
    public ResponseEntity<TicketDTO> findTicketById(@RequestParam long id) {
        return new ResponseEntity<>(ticketService.findTicketById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/cancelReservation",  produces = "application/json")
    public ResponseEntity<ReservationDTO> cancelReservation(@RequestParam long id){
        return new ResponseEntity<>(ticketService.cancelReservation(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteReservation",  produces = "application/json")
    public ResponseEntity<ReservationDTO> deleteReservation(@RequestParam long id){
        return new ResponseEntity<>(ticketService.deleteReservation(id), HttpStatus.OK);
    }
}