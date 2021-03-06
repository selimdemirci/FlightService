package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.dto.flight.FlightRouteWithAirportsDTO;
import com.demo.flightservice.model.Airport;
import com.demo.flightservice.model.FlightRoute;

public interface FlightRouteService {
    
    boolean isFlightRouteExist(Airport from, Airport destination);
    boolean isFlightRouteExist(String from, String destination);

    FlightRoute create(Airport from, Airport destination);
    FlightRoute find(Airport from, Airport destination);

    FlightRouteWithAirportsDTO add(FlightRouteDTO flightRoute);
    FlightRouteWithAirportsDTO getById(long id);
    List<FlightRouteWithAirportsDTO> getAllFlightRoutes();
}