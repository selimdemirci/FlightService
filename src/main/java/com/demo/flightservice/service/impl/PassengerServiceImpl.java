package com.demo.flightservice.service.impl;

import java.util.List;

import com.demo.flightservice.dto.passenger.PassengerDTO;
import com.demo.flightservice.model.Passenger;
import com.demo.flightservice.repository.PassengerRepository;
import com.demo.flightservice.service.PassengerService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;

    PassengerServiceImpl(PassengerRepository passengerRepository, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(PassengerDTO passenger) {
        passengerRepository.save(modelMapper.map(passenger, Passenger.class));
    }

    @Override
    public PassengerDTO getById(long id) {
        return modelMapper.map(passengerRepository.findById(id).get(), PassengerDTO.class);
    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        return modelMapper.map(passengerRepository.findAll(), new TypeToken<List<PassengerDTO>>(){}.getType());
    }

    @Override
    public Passenger findById(long id) {
        return modelMapper.map(passengerRepository.findById(id).get(), Passenger.class);
    }

    @Override
    public void save(Passenger passenger) {
        passengerRepository.save(passenger);
    }
    
}