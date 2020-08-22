package com.demo.flightservice.dto.flight;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FlightDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("flightRoute")
    private FlightRouteDTO flightRoute;

    @JsonProperty("price")
    private double price;

}