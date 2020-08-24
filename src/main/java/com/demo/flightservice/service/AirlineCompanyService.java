package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.model.AirlineCompany;

public interface AirlineCompanyService {

    AirlineCompany findByName(String companyName);

    AirlineCompanyDTO add(AirlineCompanyDTO company);
    AirlineCompanyDTO getByName(String companyName);
    List<AirlineCompanyDTO> getAllCompanies();
}