package com.demo.flightservice.util;

import org.springframework.stereotype.Component;

@Component
public class RoundNumber {

    public double roundPercentage(int current, int total) {
        double percantage = ((double) current / (double) total) * 10;

        if (percantage < 1){
            return 0;
        }
        percantage = Math.abs(percantage);

        return Math.floor(percantage / Math.pow(10, Math.floor(Math.log10(percantage))));
    }
    
}