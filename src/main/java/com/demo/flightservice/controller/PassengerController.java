package com.demo.flightservice.controller;

import java.util.List;

import com.demo.flightservice.dto.passenger.PassengerDTO;
import com.demo.flightservice.service.PassengerService;

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
@RequestMapping("/passenger")
public class PassengerController {
    
    private final PassengerService passengerService;

    PassengerController(PassengerService passengerService){
        this.passengerService = passengerService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PassengerDTO> createPassenger(@Validated @RequestBody PassengerDTO passenger){
        return new ResponseEntity<>(passengerService.add(passenger), HttpStatus.CREATED);
    }

    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

    @GetMapping(value="/find", produces = "application/json")
    public ResponseEntity<PassengerDTO> findPassenger(@RequestParam long id) {
        return new ResponseEntity<>(passengerService.getById(id), HttpStatus.OK);
    }

}