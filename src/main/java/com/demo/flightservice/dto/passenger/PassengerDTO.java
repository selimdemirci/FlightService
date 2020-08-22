package com.demo.flightservice.dto.passenger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PassengerDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("age")
    private int age;

    @JsonProperty("budget")
    private BillingAccountDTO billingAccount;
}