package com.demo.flightservice.service.impl;

import javax.transaction.Transactional;

import com.demo.flightservice.dto.flight.NewFlightDTO;
import com.demo.flightservice.enums.PlaneType;
import com.demo.flightservice.model.Flight;
import com.demo.flightservice.repository.FlightRepository;
import com.demo.flightservice.service.AirlineCompanyService;
import com.demo.flightservice.service.AirportService;
import com.demo.flightservice.service.FlightRouteService;
import com.demo.flightservice.service.FlightService;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightRouteService flightRouteService;
    private final AirlineCompanyService airlineCompanyService;
    private final AirportService airportService;

    public FlightServiceImpl(FlightRepository flightRepository, FlightRouteService flightRouteService,
            AirlineCompanyService airlineCompanyService, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.flightRouteService = flightRouteService;
        this.airlineCompanyService = airlineCompanyService;
        this.airportService = airportService;
    }

    @Override
    public boolean add(NewFlightDTO newFlight) {
        if(airlineCompanyService.isExist(newFlight.getCompany()) && flightRouteService.isFlightRouteExist(newFlight.getFrom(), newFlight.getDestination())){

            PlaneType planeType = newFlight.getPlaneType();
            int totalSeatsCount = planeType.getValue();
            //If totalSeatsCountplane = 0, that means plane type does not exist so flight will not be create.
            if(totalSeatsCount == 0){
                return false;
            }

            Flight flight = new Flight();
            flight.setTotalSeatsCount(totalSeatsCount);
            flight.setCompany(airlineCompanyService.findByName(newFlight.getCompany()));
            flight.setRoute(flightRouteService.find(airportService.findByName(newFlight.getFrom()), airportService.findByName(newFlight.getDestination())));
            flight.setPlaneType(planeType);
            flight.setDepartureTime(newFlight.getDepartureTime());
            flight.setPrice(newFlight.getPrice());
            flight.setDepartureTime(newFlight.getDepartureTime());

            flightRepository.save(flight);
            return true;
        }
        return false;
    }
    
}