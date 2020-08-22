package com.demo.flightservice.dto.ticket;

import java.time.LocalDateTime;

import com.demo.flightservice.dto.flight.FlightRouteDTO;
import com.demo.flightservice.enums.PlaneType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TicketDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("seat")
    private String seat;

    @JsonProperty("price")
    private double price;

    @JsonProperty("bookingDate")
    private LocalDateTime bookingDate;

    @JsonProperty("departureTime")
    private LocalDateTime departureTime;

    @JsonProperty("planeType")
    private PlaneType planeType;

    @JsonProperty("route")
    private FlightRouteDTO route;

}