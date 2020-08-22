package com.demo.flightservice.dto.flight;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FlightRouteDTO {
    
    @JsonProperty("from")
    private String from;

    @JsonProperty("destination")
    private String destination;
}