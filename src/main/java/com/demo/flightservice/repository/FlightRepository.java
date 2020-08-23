package com.demo.flightservice.repository;

import java.util.List;

import com.demo.flightservice.model.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByCompanyName(String companyName);
    List<Flight> findAllByRouteFromName(String airportName);
}