package com.demo.flightservice.dto.flight;

import java.time.LocalDateTime;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.enums.PlaneType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseFlightDTO {

    @JsonProperty("price")
    private double price;

    @JsonProperty("from")
    private AirportDTO from;

    @JsonProperty("destination")
    private AirportDTO destination;

    @JsonProperty("company")
    private AirlineCompanyDTO company;

    @JsonProperty("planeType")
    private PlaneType planeType;

    @JsonProperty("departureTime")
    private LocalDateTime departureTime;
    
}