package com.groupg.temperature.converter;

/*
 * Copyright 2016 Niall Quinn.
 */

/**
 *
 * @author Niall Quinn
 */
public class TemperatureConverter {
    
    public TemperatureConverter() {
        super();
    }
    
    //Convert Celsius to Fahrenheit
    public double convertCelToFar(double cel) {
        return ((cel*9)/5)+32;
    }
    
    public double convertCelToFar(int cel) {
        return ((cel*9)/5)+32;
    }
    
    //Convert Fahrenheit to Celsius
    public double convertFarToCel(double far) {
        return ((far-32)*5)/9;
    }
    
    public double convertFarToCel(int far) {
        return ((far-32)*5)/9;
    }
}
