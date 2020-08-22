package com.demo.flightservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping(value="/create")
    public ResponseEntity<String> addAirlineCompany(@Validated @RequestBody AirlineCompanyDTO company) {
        boolean isCreated = airlineCompanyService.add(company);
        if(isCreated){
            return new ResponseEntity<>("Company has been created.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Company couldn't created.", HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping(value="/all", produces = "application/json")
    public ResponseEntity<List<AirlineCompanyDTO>> addAirlineCompany() {
        return new ResponseEntity<>(airlineCompanyService.getAllCompanies(), HttpStatus.OK);
    }
    
}