package com.demo.flightservice.dto.airline;

import java.util.List;

import com.demo.flightservice.dto.flight.FlightDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AirlineWithFlightsDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("flights")
    private List<FlightDTO> flights;
}