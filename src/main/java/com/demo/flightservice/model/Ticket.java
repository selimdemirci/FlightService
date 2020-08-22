package com.demo.flightservice.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
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
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String seat;
    private LocalDateTime bookingDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID", nullable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID", nullable = false)
    private Flight flight;

}