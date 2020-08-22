package com.demo.flightservice.repository;

import com.demo.flightservice.model.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
}