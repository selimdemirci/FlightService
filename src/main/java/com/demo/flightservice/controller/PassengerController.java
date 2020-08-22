package com.demo.flightservice.controller;


import com.demo.flightservice.dto.account.PassengerDTO;
import com.demo.flightservice.service.PassengerService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class PassengerController {
    
    private final PassengerService passengerService;

    PassengerController(PassengerService passengerService){
        this.passengerService = passengerService;
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public ResponseEntity<String> createPassenger(@Validated @RequestBody PassengerDTO passenger){
        passengerService.add(passenger);
        return ResponseEntity.ok("Passenger has been created.");
    }

}