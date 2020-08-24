package com.demo.flightservice.controller;

import java.util.List;

import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.dto.flight.FlightRouteWithAirportsDTO;
import com.demo.flightservice.service.FlightRouteService;

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
@RequestMapping("/flightRoute")
public class FlightRouteController {
    
    private final FlightRouteService flightRouteService;

    public FlightRouteController(FlightRouteService flightRouteService) {
        this.flightRouteService = flightRouteService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<FlightRouteWithAirportsDTO> createFlightRoute(@Validated @RequestBody FlightRouteDTO flightRoute){
        return new ResponseEntity<>(flightRouteService.add(flightRoute), HttpStatus.CREATED);
    }

    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<FlightRouteWithAirportsDTO>> getAllFlightRoutes() {
        return new ResponseEntity<>(flightRouteService.getAllFlightRoutes(), HttpStatus.OK);
    }

    @GetMapping(value="/find", produces = "application/json")
    public ResponseEntity<FlightRouteWithAirportsDTO> findFlightRoute(@RequestParam long id) {
        return new ResponseEntity<>(flightRouteService.getById(id), HttpStatus.OK);
    }


}