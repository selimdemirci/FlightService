package com.demo.flightservice.service.impl;

import java.util.List;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.exception.AirlineCompanyException;
import com.demo.flightservice.exception.DataNotFoundException;
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
    public AirlineCompanyDTO add(AirlineCompanyDTO company) {
        AirlineCompany newCompany;
        try {
            newCompany = airlineCompanyRepository.save(modelMapper.map(company, AirlineCompany.class));
        } catch (Exception e) {
            throw new AirlineCompanyException(company.getName() + " already exists!");
        }
        return modelMapper.map(newCompany, AirlineCompanyDTO.class);
    }

    @Override
    public AirlineCompany findByName(String companyName) {
        return airlineCompanyRepository.findByName(companyName)
            .orElseThrow(() -> new DataNotFoundException("Airline company " + companyName + " not found!"));
    }

    @Override
    public List<AirlineCompanyDTO> getAllCompanies() {
        return modelMapper.map(airlineCompanyRepository.findAll(), new TypeToken<List<AirlineCompanyDTO>>(){}.getType());
    }

    @Override
    public AirlineCompanyDTO getByName(String companyName) {
        return modelMapper.map(airlineCompanyRepository.findByName(companyName)
            .orElseThrow(() -> new DataNotFoundException("Airline company " + companyName + " not found!")), AirlineCompanyDTO.class);
    }
    
}