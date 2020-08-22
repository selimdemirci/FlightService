package com.demo.flightservice.dto.airport;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AirportDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("city")
    private String city;
}