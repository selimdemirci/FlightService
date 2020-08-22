package com.demo.flightservice.service.impl;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.model.AirlineCompany;
import com.demo.flightservice.repository.AirlineCompanyRepository;
import com.demo.flightservice.service.AirlineCompanyService;

import org.springframework.stereotype.Service;

@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    private final AirlineCompanyRepository airlineCompanyRepository;

    AirlineCompanyServiceImpl(AirlineCompanyRepository airlineCompanyRepository){
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    @Override
    public AirlineCompanyDTO add(AirlineCompanyDTO company) {
        AirlineCompany newCompany = new AirlineCompany();
        newCompany.setName(company.getName());
        airlineCompanyRepository.save(newCompany);
        return company;
    }
    
}