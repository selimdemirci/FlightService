package com.demo.flightservice.service;

import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.model.Airport;
import com.demo.flightservice.model.FlightRoute;

public interface FlightRouteService {
    
    boolean add(FlightRouteDTO flightRoute);
    boolean isAirportsExist(FlightRouteDTO flightRoute);
    boolean isFlightRouteExist(Airport from, Airport destination);

    FlightRoute create(Airport from, Airport destination);
    FlightRoute find(Airport from, Airport destination);
}