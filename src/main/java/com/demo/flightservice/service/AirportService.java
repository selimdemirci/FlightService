package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.model.Airport;

public interface AirportService {

    boolean add(AirportDTO airport);
    boolean isExist(String airportName);
    Airport findByName(String airportName);
    AirportDTO getByName(String airportName);
    List<AirportDTO> getAllAirports();
    
}