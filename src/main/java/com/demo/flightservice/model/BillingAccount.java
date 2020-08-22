package com.demo.flightservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class BillingAccount {
    
    @Id
    @Column(name = "BILLING_ACCOUNT_ID")
    private long id;

    private String creditCardNumber;
    private double budget;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="BILLING_ACCOUNT_ID", referencedColumnName="BILLING_ACCOUNT_ID")
    private Passenger passenger;
}