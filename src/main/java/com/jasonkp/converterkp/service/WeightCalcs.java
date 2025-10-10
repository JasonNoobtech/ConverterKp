package com.jasonkp.converterkp.service;

import org.springframework.stereotype.Service;

@Service
public class WeightCalcs implements Converter {
    @Override
    public double convert(double value, String from, String to) {

        if (from.equals(to)) {
            return value;
        }

        if (value <= 0) {
            throw new RuntimeException("Weight cannot be less than 0");
        }

        double kilograms;
        if (from.equals("Kilograms")) {
            kilograms = value;
        } else if (from.equals("Pounds")) {
            kilograms = value * 0.453592;
        } else if (from.equals("Ounces")) {
            kilograms = value * 0.0283495;
        } else if (from.equals("Grams")) {
            kilograms = value * 0.001;
        } else if (from.equals("Tons")) {
            kilograms = value * 1000;
        } else {
            throw new IllegalArgumentException("Invalid from unit: " + from);
        }

        if (to.equals("Kilograms")) {
            return kilograms;
        } else if (to.equals("Pounds")) {
            return kilograms / 0.453592;
        } else if (to.equals("Ounces")) {
            return kilograms / 0.0283495;
        } else if (to.equals("Grams")) {
            return kilograms / 0.001;
        } else if (to.equals("Tons")) {
            return kilograms / 1000;
        } else {
            throw new IllegalArgumentException("Invalid to unit: " + to);
        }
    }
}
