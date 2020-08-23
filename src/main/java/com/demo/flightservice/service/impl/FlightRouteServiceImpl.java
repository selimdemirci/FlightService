package com.demo.flightservice.service.impl;

import java.util.List;

import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.dto.flight.FlightRouteWithAirpotsDTO;
import com.demo.flightservice.model.Airport;
import com.demo.flightservice.model.FlightRoute;
import com.demo.flightservice.repository.FlightRouteRepository;
import com.demo.flightservice.service.AirportService;
import com.demo.flightservice.service.FlightRouteService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightRouteServiceImpl implements FlightRouteService {

    private final FlightRouteRepository flightRouteRepository;
    private final AirportService airportService;
    private final ModelMapper modelMapper;

    FlightRouteServiceImpl(FlightRouteRepository flightRouteRepository, AirportService airportService, ModelMapper modelMapper) {
        this.flightRouteRepository = flightRouteRepository;
        this.airportService = airportService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean add(FlightRouteDTO flightRoute) {

        if (isAirportsExist(flightRoute) && !flightRoute.getFrom().equals(flightRoute.getDestination())) {
            Airport from = airportService.findByName(flightRoute.getFrom());
            Airport destination = airportService.findByName(flightRoute.getDestination());

            if (isFlightRouteExist(from, destination)) {
                return false;
            }

            flightRouteRepository.save(create(from, destination));
            return true;
        }
        return false;
    }

    public boolean isAirportsExist(FlightRouteDTO flightRoute) {
        return airportService.isExist(flightRoute.getFrom()) && airportService.isExist(flightRoute.getDestination());
    }

    public boolean isFlightRouteExist(Airport from, Airport destination) {
        return flightRouteRepository.flightRouteCount(from, destination) > 0;
    }

    public boolean isFlightRouteExist(String from, String destination) {
        Airport fromA = airportService.findByName(from);
        Airport destinationA = airportService.findByName(destination);

        return flightRouteRepository.flightRouteCount(fromA, destinationA) > 0;
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

    @Override
    public List<FlightRouteWithAirpotsDTO> getAllFlightRoutes() {
        return modelMapper.map(flightRouteRepository.findAll(), new TypeToken<List<FlightRouteWithAirpotsDTO>>(){}.getType());
    }

    @Override
    public FlightRouteWithAirpotsDTO getById(long id) {
        return modelMapper.map(flightRouteRepository.findById(id).get(), FlightRouteWithAirpotsDTO.class);
    }
}