package com.demo.flightservice.repository;

import com.demo.flightservice.model.Airport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    Airport findByName(String name);
    boolean existsByName(String name);

}