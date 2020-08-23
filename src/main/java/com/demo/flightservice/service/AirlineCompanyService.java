package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.model.AirlineCompany;

public interface AirlineCompanyService {

    boolean add(AirlineCompanyDTO company);
    boolean isExist(String companyName);
    AirlineCompany findByName(String companyName);
    AirlineCompanyDTO getByName(String companyName);
    List<AirlineCompanyDTO> getAllCompanies();

}