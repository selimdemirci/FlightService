package com.demo.flightservice.repository;

import com.demo.flightservice.model.FlightRoute;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRouteRepository extends JpaRepository<FlightRoute, Long>{
    
}