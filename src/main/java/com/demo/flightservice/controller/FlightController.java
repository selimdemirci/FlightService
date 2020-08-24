package com.demo.flightservice.controller;

import java.util.List;

import com.demo.flightservice.dto.flight.FlightDTO;
import com.demo.flightservice.dto.flight.NewFlightDTO;
import com.demo.flightservice.dto.flight.ResponseFlightDTO;
import com.demo.flightservice.service.FlightService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseFlightDTO> createNewFlight(@Validated @RequestBody NewFlightDTO flight){
        return new ResponseEntity<>(flightService.add(flight), HttpStatus.CREATED);
    }

    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value="/find", produces = "application/json")
    public ResponseEntity<FlightDTO> findFlightById(@RequestParam long id) {
        return new ResponseEntity<>(flightService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value="/company", produces = "application/json")
    public ResponseEntity<List<FlightDTO>> getAllFlightsByCompany(@RequestParam String companyName) {
        return new ResponseEntity<>(flightService.getAllFlightsByCompany(companyName), HttpStatus.OK);
    }

    @GetMapping(value="/airport", produces = "application/json")
    public ResponseEntity<List<FlightDTO>> getAllFlightsByAirport(@RequestParam String airportName) {
        return new ResponseEntity<>(flightService.getAllFlightsByAirport(airportName), HttpStatus.OK);
    }
}