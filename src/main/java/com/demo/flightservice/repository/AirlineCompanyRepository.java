package com.demo.flightservice.repository;

import com.demo.flightservice.model.AirlineCompany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long>{
    
}