package com.demo.flightservice.dto.passenger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BillingAccountDTO {
    
    @JsonProperty("creditCardNumber")
    private String creditCardNumber;

    @JsonProperty("budget")
    private double budget;

}