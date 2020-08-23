package com.demo.flightservice.controller;

import java.util.List;

import com.demo.flightservice.dto.flight.FlightDTO;
import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.dto.flight.FlightRouteWithAirportsDTO;
import com.demo.flightservice.dto.flight.NewFlightDTO;
import com.demo.flightservice.service.FlightRouteService;
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
            return new ResponseEntity<>("Flight route has been created.", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Flight route couldn't created.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/route/all", produces = "application/json")
    public ResponseEntity<List<FlightRouteWithAirportsDTO>> getAllFlightRoutes() {
        return new ResponseEntity<>(flightRouteService.getAllFlightRoutes(), HttpStatus.OK);
    }

    @GetMapping(value="/route/find", produces = "application/json")
    public ResponseEntity<FlightRouteWithAirportsDTO> findFlightRoute(@RequestParam long id) {
        return new ResponseEntity<>(flightRouteService.getById(id), HttpStatus.OK);
    }


    @PostMapping(path = "/create", consumes = "application/json")
    public ResponseEntity<String> createNewFlight(@Validated @RequestBody NewFlightDTO flight){
        boolean isCreated = flightService.add(flight);
        if(isCreated){
            return new ResponseEntity<>("New flight has been created.", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("New flight couldn't created.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value="/find", produces = "application/json")
    public ResponseEntity<FlightDTO> findFlight(@RequestParam long id) {
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