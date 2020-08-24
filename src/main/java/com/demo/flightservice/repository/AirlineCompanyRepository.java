package com.demo.flightservice.repository;

import java.util.Optional;

import com.demo.flightservice.model.AirlineCompany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long>{
    
    Optional<AirlineCompany> findByName(String name);

}