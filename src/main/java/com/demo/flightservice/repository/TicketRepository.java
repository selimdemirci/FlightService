package com.demo.flightservice.repository;

import com.demo.flightservice.model.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
}