package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.flight.NewFlightDTO;
import com.demo.flightservice.model.Flight;
import com.demo.flightservice.dto.flight.FlightDTO;

public interface FlightService {

    boolean add(NewFlightDTO newFlight);
    List<FlightDTO> getAllFlights();
    Flight findById(long id);
    void save(Flight flight);
}