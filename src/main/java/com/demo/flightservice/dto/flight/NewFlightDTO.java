package com.demo.flightservice.dto.flight;

import java.time.LocalDateTime;

import com.demo.flightservice.dto.airline.AirlineCompanyDTO;
import com.demo.flightservice.enums.PlaneType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NewFlightDTO {

    @JsonProperty("price")
    private double price;

    @JsonProperty("planeType")
    private PlaneType planeType;

    @JsonProperty("departureTime")
    private LocalDateTime departureTime;

    @JsonProperty("route")
    private FlightRouteDTO route;

    @JsonProperty("company")
    private AirlineCompanyDTO company;
    
}