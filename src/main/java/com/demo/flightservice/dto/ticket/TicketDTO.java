package com.demo.flightservice.dto.ticket;

import java.time.LocalDateTime;

import com.demo.flightservice.dto.airport.AirportDTO;
import com.demo.flightservice.enums.TicketStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TicketDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

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

    @JsonProperty("from")
    private AirportDTO from;

    @JsonProperty("destination")
    private AirportDTO destination;

    @JsonProperty("ticketStatus")
    private TicketStatus ticketStatus;

}