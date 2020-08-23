package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.dto.flight.FlightRouteWithAirpotsDTO;
import com.demo.flightservice.model.Airport;
import com.demo.flightservice.model.FlightRoute;

public interface FlightRouteService {
    
    boolean add(FlightRouteDTO flightRoute);
    boolean isAirportsExist(FlightRouteDTO flightRoute);
    boolean isFlightRouteExist(Airport from, Airport destination);
    boolean isFlightRouteExist(String from, String destination);

    FlightRoute create(Airport from, Airport destination);
    FlightRoute find(Airport from, Airport destination);

    FlightRouteWithAirpotsDTO getById(long id);
    List<FlightRouteWithAirpotsDTO> getAllFlightRoutes();
}