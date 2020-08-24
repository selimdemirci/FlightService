package com.demo.flightservice.service.impl;

import java.util.List;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.exception.AirportException;
import com.demo.flightservice.model.Airport;
import com.demo.flightservice.repository.AirportRepository;
import com.demo.flightservice.service.AirportService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;

    AirportServiceImpl(AirportRepository airportRepository, ModelMapper modelMapper) {
        this.airportRepository = airportRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AirportDTO add(AirportDTO airport) {
        Airport newAirport = airportRepository.save( modelMapper.map(airport, Airport.class));
        return modelMapper.map(newAirport, AirportDTO.class);
    }

    @Override
    public boolean isExist(String airportName) {
        return airportRepository.existsByName(airportName);
    }

    @Override
    public Airport findByName(String airportName) {
        return airportRepository.findByName(airportName);
    }

    @Override
    public AirportDTO getByName(String airportName) {
        AirportDTO airport = modelMapper.map(findByName(airportName), AirportDTO.class);  
        if(airport == null){
            throw new AirportException("Airport does not exist.");
        }
        return airport;
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        return modelMapper.map(airportRepository.findAll(), new TypeToken<List<AirportDTO>>(){}.getType());
    }
    
    @Override
    public boolean isAirportsExist(FlightRouteDTO flightRoute) {
        return isExist(flightRoute.getFrom()) && isExist(flightRoute.getDestination());
    }
}