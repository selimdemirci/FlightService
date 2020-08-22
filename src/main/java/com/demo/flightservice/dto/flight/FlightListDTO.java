package com.demo.flightservice.dto.flight;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FlightListDTO {

    @JsonProperty("flights")
    List<FlightDTO> flights;
    
}