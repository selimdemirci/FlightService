package com.demo.flightservice.dto.passenger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PassengerDTO {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("age")
    private int age;

    @JsonProperty("creditCardNumber")
    private String creditCardNumber;

    @JsonProperty("budget")
    private double budget;

}