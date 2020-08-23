package com.demo.flightservice.service;

import java.util.List;

import com.demo.flightservice.dto.account.PassengerDTO;

public interface PassengerService {
    
    void add(PassengerDTO passenger);
    PassengerDTO getById(long id);
    List<PassengerDTO> getAllPassengers();
}