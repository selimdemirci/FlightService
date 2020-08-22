package com.demo.flightservice.controller;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.service.AirportService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    AirportController(AirportService airportService){
        this.airportService = airportService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createAirport(@Validated @RequestBody AirportDTO airport){
        boolean isCreated = airportService.add(airport);
        if(isCreated){
            return new ResponseEntity<>("Airport has been created.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Airport couldn't created.", HttpStatus.BAD_REQUEST);
        }
    }
    
}