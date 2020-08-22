package com.demo.flightservice.repository;

import com.demo.flightservice.model.Airport;
import com.demo.flightservice.model.FlightRoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlightRouteRepository extends JpaRepository<FlightRoute, Long>{
    
    @Query(value = "select count(ID) from FlightRoute where FROM_AIRPORT_ID = ?1 and DESTINATION_AIRPORT_ID = ?2")
    int flightRouteCount(Airport from, Airport destination);

    @Query(value = "from FlightRoute where FROM_AIRPORT_ID = ?1 and DESTINATION_AIRPORT_ID = ?2")
    FlightRoute find(Airport from, Airport destination);

}