package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.passenger.PassengerDTO;
import com.demo.flightservice.model.Passenger;

public interface PassengerService {
    
    void add(PassengerDTO passenger);
    PassengerDTO getById(long id);
    List<PassengerDTO> getAllPassengers();
    Passenger findById(long id);
    void save(Passenger passenger);
}