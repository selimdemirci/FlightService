package com.demo.flightservice.dto.flight;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FlightRouteWithAirportsDTO {

    @JsonProperty("from")
    private AirportDTO from;

    @JsonProperty("destination")
    private AirportDTO destination;
    
}