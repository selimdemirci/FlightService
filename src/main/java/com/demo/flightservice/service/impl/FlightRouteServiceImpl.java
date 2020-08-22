package com.demo.flightservice.service.impl;

import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.model.Airport;
import com.demo.flightservice.model.FlightRoute;
import com.demo.flightservice.repository.FlightRouteRepository;
import com.demo.flightservice.service.AirportService;
import com.demo.flightservice.service.FlightRouteService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightRouteServiceImpl implements FlightRouteService {

    private final FlightRouteRepository flightRouteRepository;
    private final AirportService airportService;

    FlightRouteServiceImpl(FlightRouteRepository flightRouteRepository, AirportService airportService){
        this.flightRouteRepository = flightRouteRepository;
        this.airportService = airportService;
    }

    @Override
    public boolean add(FlightRouteDTO flightRoute) {

        if(isAirportsExist(flightRoute) && !flightRoute.getFrom().equals(flightRoute.getDestination())){
            Airport from = airportService.findByName(flightRoute.getFrom());
            Airport destination = airportService.findByName(flightRoute.getDestination());

            if(isFlightRouteExist(from, destination)){
                return false;
            }
            
            flightRouteRepository.save(create(from, destination));
            return true;
        }
        return false;
    }

    public boolean isAirportsExist(FlightRouteDTO flightRoute){
        return airportService.isExist(flightRoute.getFrom()) && airportService.isExist(flightRoute.getDestination());
    }

    public boolean isFlightRouteExist(Airport from, Airport destination){
        return flightRouteRepository.flightRouteCount(from,destination) > 0;
    }

    @Override
    public FlightRoute create(Airport from, Airport destination) {
        FlightRoute newFlightRoute = new FlightRoute();
        newFlightRoute.setFrom(from);
        newFlightRoute.setDestination(destination);

        return newFlightRoute;
    }
    
    @Override
    public FlightRoute find(Airport from, Airport destination) {
        return flightRouteRepository.find(from, destination);
    }
}