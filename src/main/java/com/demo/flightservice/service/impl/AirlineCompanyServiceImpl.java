package com.demo.flightservice.service.impl;

import java.util.List;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.model.AirlineCompany;
import com.demo.flightservice.repository.AirlineCompanyRepository;
import com.demo.flightservice.service.AirlineCompanyService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    public boolean add(AirlineCompanyDTO company) {
        if(!isExist(company.getName())){
            AirlineCompany newCompany = modelMapper.map(company, AirlineCompany.class);
            airlineCompanyRepository.save(newCompany);
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(String companyName) {
        return airlineCompanyRepository.existsByName(companyName);
    }

    @Override
    public AirlineCompany findByName(String companyName) {
        return airlineCompanyRepository.findByName(companyName);
    }

    @Override
    public List<AirlineCompanyDTO> getAllCompanies() {
        return modelMapper.map(airlineCompanyRepository.findAll(), new TypeToken<List<AirlineCompanyDTO>>(){}.getType());
    }
    
}