package com.demo.flightservice.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class FlightRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FROM_AIRPORT_ID", nullable = false)
    private Airport from;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DESTINATION_AIRPORT_ID", nullable = false)
    private Airport destination;
    
}