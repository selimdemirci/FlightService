package com.demo.flightservice.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.demo.flightservice.enums.PlaneType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double price;
    private int bookedSeatsCount;
    private int totalSeatsCount;

    @Enumerated(EnumType.STRING)
    private PlaneType planeType;

    private LocalDateTime departureTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private AirlineCompany company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FLIGHT_ROUTE_ID", nullable = false)
    private FlightRoute route;
    
}