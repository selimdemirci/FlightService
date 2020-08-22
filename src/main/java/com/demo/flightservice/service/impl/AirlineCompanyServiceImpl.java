package com.demo.flightservice.service.impl;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.model.AirlineCompany;
import com.demo.flightservice.repository.AirlineCompanyRepository;
import com.demo.flightservice.service.AirlineCompanyService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirlineCompanyServiceImpl implements AirlineCompanyService {

    private final AirlineCompanyRepository airlineCompanyRepository;
    private final ModelMapper modelMapper;

    AirlineCompanyServiceImpl(AirlineCompanyRepository airlineCompanyRepository, ModelMapper modelMapper) {
        this.airlineCompanyRepository = airlineCompanyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(AirlineCompanyDTO company) {
        AirlineCompany newCompany = modelMapper.map(company, AirlineCompany.class);
        airlineCompanyRepository.save(newCompany);
    }

    @Override
    public boolean isExist(String companyName) {
        return airlineCompanyRepository.existsByName(companyName);
    }

    @Override
    public AirlineCompany findByName(String companyName) {
        return airlineCompanyRepository.findByName(companyName);
    }
    
}