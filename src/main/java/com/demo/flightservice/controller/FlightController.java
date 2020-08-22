package com.demo.flightservice.controller;

import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.dto.flight.NewFlightDTO;
import com.demo.flightservice.service.FlightRouteService;
import com.demo.flightservice.service.FlightService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightRouteService flightRouteService;
    private final FlightService flightService;

    FlightController(FlightRouteService flightRouteService, FlightService flightService){
        this.flightRouteService = flightRouteService;
        this.flightService = flightService;
    }
    
    @PostMapping(path = "/route/create", consumes = "application/json")
    public ResponseEntity<String> createFlightRoute(@Validated @RequestBody FlightRouteDTO flightRoute){
        boolean isCreated = flightRouteService.add(flightRoute);
        if(isCreated){
            return new ResponseEntity<>("Flight route has been created.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Flight route couldn't created.", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(path = "/create", consumes = "application/json")
    public ResponseEntity<String> createNewFlight(@Validated @RequestBody NewFlightDTO flight){
        boolean isCreated = flightService.add(flight);
        if(isCreated){
            return new ResponseEntity<>("New flight has been created.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("New flight couldn't created.", HttpStatus.BAD_REQUEST);
        }
    }
}