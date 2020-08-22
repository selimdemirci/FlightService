package com.demo.flightservice.service;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.model.Airport;

public interface AirportService {

    boolean add(AirportDTO airport);
    boolean isExist(String airportName);
    Airport findByName(String airportName);
    
}