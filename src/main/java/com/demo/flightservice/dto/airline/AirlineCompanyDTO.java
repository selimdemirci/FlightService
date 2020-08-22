package com.demo.flightservice.dto.airline;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AirlineCompanyDTO {
    
    @JsonProperty("name")
    private String name;
}