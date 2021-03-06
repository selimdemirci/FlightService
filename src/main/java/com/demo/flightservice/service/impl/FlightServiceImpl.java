package com.demo.flightservice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.demo.flightservice.dto.flight.FlightDTO;
import com.demo.flightservice.dto.flight.NewFlightDTO;
import com.demo.flightservice.dto.flight.ResponseFlightDTO;
import com.demo.flightservice.enums.PlaneType;
import com.demo.flightservice.exception.DataNotFoundException;
import com.demo.flightservice.model.Flight;
import com.demo.flightservice.repository.FlightRepository;
import com.demo.flightservice.service.AirlineCompanyService;
import com.demo.flightservice.service.AirportService;
import com.demo.flightservice.service.FlightRouteService;
import com.demo.flightservice.service.FlightService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightRouteService flightRouteService;
    private final AirlineCompanyService airlineCompanyService;
    private final AirportService airportService;
    private final ModelMapper modelMapper;

    public FlightServiceImpl(FlightRepository flightRepository, FlightRouteService flightRouteService,
            AirlineCompanyService airlineCompanyService, AirportService airportService, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.flightRouteService = flightRouteService;
        this.airlineCompanyService = airlineCompanyService;
        this.airportService = airportService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseFlightDTO add(NewFlightDTO newFlight) {
        Flight flight = new Flight();

        PlaneType planeType = newFlight.getPlaneType();
        int totalSeatsCount = planeType.getValue();

        flight.setTotalSeatsCount(totalSeatsCount);
        flight.setCompany(airlineCompanyService.findByName(newFlight.getCompany()));
        flight.setRoute(flightRouteService.find(airportService.findByName(newFlight.getFrom()),
                airportService.findByName(newFlight.getDestination())));
        flight.setPlaneType(planeType);
        flight.setDepartureTime(newFlight.getDepartureTime());
        flight.setPrice(newFlight.getPrice());
        flight.setDepartureTime(newFlight.getDepartureTime());

        flightRepository.save(flight);

        return modelMapper.map(flight, ResponseFlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return  modelMapper.map(flightRepository.findAll(), new TypeToken<List<FlightDTO>>(){}.getType());
    }

    @Override
    public Flight findById(long id) {
        return modelMapper.map(flightRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Flight with ID " + id + " not found!")), Flight.class);
    }

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public FlightDTO getById(long id) {
        return modelMapper.map(flightRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Flight with ID " + id + " not found!")), FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAllFlightsByCompany(String companyName) {
        return modelMapper.map(flightRepository.findAllByCompanyName(companyName), new TypeToken<List<FlightDTO>>(){}.getType());
    }

    @Override
    public List<FlightDTO> getAllFlightsByAirport(String airportName) {
        return modelMapper.map(flightRepository.findAllByRouteFromName(airportName), new TypeToken<List<FlightDTO>>(){}.getType());
    }
    
}