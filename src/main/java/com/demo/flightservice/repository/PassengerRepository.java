package com.demo.flightservice.repository;

import com.demo.flightservice.model.Passenger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{
    
}