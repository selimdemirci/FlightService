package com.demo.flightservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.service.AirlineCompanyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/company")
public class AirlineCompanyController {

    private final AirlineCompanyService airlineCompanyService;

    AirlineCompanyController(AirlineCompanyService airlineCompanyService){
        this.airlineCompanyService = airlineCompanyService;
    }

    @PostMapping(value="/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AirlineCompanyDTO> addAirlineCompany(@Validated @RequestBody AirlineCompanyDTO company) {
        return new ResponseEntity<>(airlineCompanyService.add(company), HttpStatus.CREATED);
    }
    
    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<AirlineCompanyDTO>> getAllAirlineCompanies() {
        return new ResponseEntity<>(airlineCompanyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping(value="/find", produces = "application/json")
    public ResponseEntity<AirlineCompanyDTO> findAirlineCompanyByName(@RequestParam String company) {
        return new ResponseEntity<>(airlineCompanyService.getByName(company), HttpStatus.OK);
    }
    
}