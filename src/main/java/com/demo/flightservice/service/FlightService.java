package com.demo.flightservice.service;

import com.demo.flightservice.dto.flight.NewFlightDTO;

public interface FlightService {

    boolean add(NewFlightDTO newFlight);
}