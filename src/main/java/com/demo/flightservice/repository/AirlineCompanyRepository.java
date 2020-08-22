package com.demo.flightservice.repository;

import java.util.List;

import com.demo.flightservice.model.AirlineCompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long>{
    
    AirlineCompany findByName(String name);
    boolean existsByName(String name);

    @Query(value = "select name, flights from AirlineCompany where name = ?1")
    List<AirlineCompany> getAllFlights(String name);

}