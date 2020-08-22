package com.demo.flightservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.service.impl.AirlineCompanyServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/company")
public class AirlineCompanyController {

    private final AirlineCompanyServiceImpl airlineCompanyService;

    AirlineCompanyController(AirlineCompanyServiceImpl airlineCompanyService){
        this.airlineCompanyService = airlineCompanyService;
    }

    @PostMapping(value="/add")
    public ResponseEntity<AirlineCompanyDTO> addAirlineCompany(@RequestBody AirlineCompanyDTO entity) {
        return ResponseEntity.ok(airlineCompanyService.add(entity));
    }
    
    
}