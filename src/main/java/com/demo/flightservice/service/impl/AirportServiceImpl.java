package com.demo.flightservice.service.impl;

import java.util.List;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.exception.AirportException;
import com.demo.flightservice.exception.DataNotFoundException;
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
        Airport newAirport;
        try {
            newAirport = airportRepository.save( modelMapper.map(airport, Airport.class));
        } catch (Exception e) {
            throw new AirportException(airport.getName() + " already exists!");
        }
        return modelMapper.map(newAirport, AirportDTO.class);
    }

    @Override
    public Airport findByName(String airportName) {
        return airportRepository.findByName(airportName)
            .orElseThrow(() -> new DataNotFoundException(airportName + " Airport not found!"));
    }

    @Override
    public AirportDTO getByName(String airportName) {
        return modelMapper.map(airportRepository.findByName(airportName)
            .orElseThrow(() -> new DataNotFoundException(airportName + " Airport not found!")), AirportDTO.class);
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        return modelMapper.map(airportRepository.findAll(), new TypeToken<List<AirportDTO>>(){}.getType());
    }
}