package com.demo.flightservice.service;

import com.demo.flightservice.dto.flight.NewFlightDTO;

public interface FlightService {

    boolean add(NewFlightDTO newFlight);
    boolean isCompanyExist(String company);
    boolean isRouteExist(String from, String destination);
}