package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.model.Airport;

public interface AirportService {
    
    Airport findByName(String airportName);

    AirportDTO add(AirportDTO airport);
    AirportDTO getByName(String airportName);
    List<AirportDTO> getAllAirports();
}