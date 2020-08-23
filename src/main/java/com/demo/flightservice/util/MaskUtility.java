package com.demo.flightservice.util;

import org.springframework.stereotype.Component;

@Component
public class MaskUtility {
    

    public String maskCreditCardNumber(String creditCardNumber){
        String onlyDigits = creditCardNumber.replaceAll("\\D+","");
        String result = onlyDigits.replaceAll("\\b(\\d{4})\\d+(\\d)", "$1*******$2");
        return result;
    }

}