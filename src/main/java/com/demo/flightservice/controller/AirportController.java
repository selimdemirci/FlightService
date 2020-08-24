package com.demo.flightservice.controller;

import java.util.List;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.service.AirportService;

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
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    AirportController(AirportService airportService){
        this.airportService = airportService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AirportDTO> createAirport(@Validated @RequestBody AirportDTO airport){
        return new ResponseEntity<>(airportService.add(airport), HttpStatus.CREATED);
    }

    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        return new ResponseEntity<>(airportService.getAllAirports(), HttpStatus.OK);
    }

    @GetMapping(value="/find", produces = "application/json")
    public ResponseEntity<AirportDTO> findAirport(@RequestParam String airport) {
        return new ResponseEntity<>(airportService.getByName(airport), HttpStatus.OK);
    }
    
}