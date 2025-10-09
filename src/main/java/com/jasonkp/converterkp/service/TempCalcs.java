package com.jasonkp.converterkp.service;

import org.springframework.stereotype.Service;

@Service
public class TempCalcs implements Converter {
    @Override
    public double convert(double value, String from, String to) {
        // Same unit conversion
        if (from.equals(to)) {
            return value;
        }

        // Convert to Celsius first
        double celsius;
        if (from.equals("Celsius")) {
            celsius = value;
        } else if (from.equals("Fahrenheit")) {
            celsius = (value - 32) * 5.0/9.0;
        } else if (from.equals("Kelvin")) {
            celsius = value - 273.15;
        } else {
            throw new IllegalArgumentException("Invalid from unit: " + from);
        }

        // Convert from Celsius to target unit
        if (to.equals("Celsius")) {
            return celsius;
        } else if (to.equals("Fahrenheit")) {
            return celsius * 9.0/5.0 + 32;
        } else if (to.equals("Kelvin")) {
            return celsius + 273.15;
        } else {
            throw new IllegalArgumentException("Invalid to unit: " + to);
        }
    }
}