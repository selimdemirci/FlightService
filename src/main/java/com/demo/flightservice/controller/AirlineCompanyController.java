package com.demo.flightservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.service.AirlineCompanyService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/company")
public class AirlineCompanyController {

    private final AirlineCompanyService airlineCompanyService;

    AirlineCompanyController(AirlineCompanyService airlineCompanyService){
        this.airlineCompanyService = airlineCompanyService;
    }

    @PostMapping(value="/create")
    public ResponseEntity<String> addAirlineCompany(@Validated @RequestBody AirlineCompanyDTO company) {
        airlineCompanyService.add(company);
        return ResponseEntity.ok(company.toString() + " has been created.");
    }
    
    
}