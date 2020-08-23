package com.demo.flightservice.dto.flight;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.enums.PlaneType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FlightDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("from")
    private AirportDTO from;

    @JsonProperty("destination")
    private AirportDTO destination;

    @JsonProperty("price")
    private double price;

    @JsonProperty("extraPriceCoefficient")
    private double extraPriceCoefficient;

    @JsonProperty("bookedSeatsCount")
    private int bookedSeatsCount;

    @JsonProperty("totalSeatsCount")
    private int totalSeatsCount;

    @JsonProperty("planeType")
    private PlaneType planeType;

}