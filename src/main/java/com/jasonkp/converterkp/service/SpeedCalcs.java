package com.jasonkp.converterkp.service;

import org.springframework.stereotype.Service;

@Service
public class SpeedCalcs implements Converter {

    @Override
    public double convert(double value, String from, String to) {

        if (from.equals(to)) {
            return value;
        }

        double metersPerSecond;
        if (from.equals("Meters per second")) {
            metersPerSecond = value;
        } else if (from.equals("Kilometers per hour")) {
            metersPerSecond = value * 0.277778;
        } else if (from.equals("Miles per hour")) {
            metersPerSecond = value * 0.44704;
        } else if (from.equals("Knots")) {
            metersPerSecond = value * 0.514444;
        } else {
            throw new IllegalArgumentException("Invalid from unit: " + from);
        }

        if (to.equals("Meters per second")) {
            return metersPerSecond;
        } else if (to.equals("Kilometers per hour")) {
            return metersPerSecond / 0.277778;
        } else if (to.equals("Miles per hour")) {
            return metersPerSecond / 0.44704;
        } else if (to.equals("Knots")) {
            return metersPerSecond / 0.514444;
        } else {
            throw new IllegalArgumentException("Invalid to unit: " + to);
        }

    }
}
