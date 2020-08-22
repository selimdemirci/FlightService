package com.demo.flightservice.dto.ticket;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReservationDTO {

    @JsonProperty("flightId")
    private long flightId;
    
    @JsonProperty("passengerId")
    private long passengerId;

}