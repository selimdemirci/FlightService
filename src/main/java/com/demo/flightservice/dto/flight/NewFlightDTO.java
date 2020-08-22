package com.demo.flightservice.dto.flight;

import java.time.LocalDateTime;

import com.demo.flightservice.enums.PlaneType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NewFlightDTO {

    @JsonProperty("price")
    private double price;

    @JsonProperty("from")
    private String from;

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("company")
    private String company;

    @JsonProperty("planeType")
    private PlaneType planeType;

    @JsonProperty("departureTime")
    private LocalDateTime departureTime;
    
}