package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.flight.NewFlightDTO;
import com.demo.flightservice.dto.flight.ResponseFlightDTO;
import com.demo.flightservice.model.Flight;
import com.demo.flightservice.dto.flight.FlightDTO;

public interface FlightService {

    void save(Flight flight);

    ResponseFlightDTO add(NewFlightDTO newFlight);

    Flight findById(long id);

    FlightDTO getById(long id);
    List<FlightDTO> getAllFlights();
    List<FlightDTO> getAllFlightsByCompany(String companyName);
    List<FlightDTO> getAllFlightsByAirport(String airportName);
}