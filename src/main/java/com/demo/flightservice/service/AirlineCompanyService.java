package com.demo.flightservice.service;


import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.model.AirlineCompany;

public interface AirlineCompanyService {

    void add(AirlineCompanyDTO company);
    boolean isExist(String companyName);
    AirlineCompany findByName(String companyName);

}