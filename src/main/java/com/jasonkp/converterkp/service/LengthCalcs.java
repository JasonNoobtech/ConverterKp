package com.jasonkp.converterkp.service;

import org.springframework.stereotype.Service;

@Service
public class LengthCalcs implements Converter{

    @Override
    public double convert(double value, String from, String to) {

        if (from.equals(to)) {
            return value;
        }

        double meters;
        if (from.equals("Meters")) {
            meters = value;
        } else if (from.equals("Feet")) {
            meters = value * 0.3048;
        } else if (from.equals("Inches")) {
            meters = value * 0.0254;
        } else if (from.equals("Centimeters")) {
            meters = value * 0.01;
        } else if (from.equals("Yards")) {
            meters = value * 0.9144;
        } else if (from.equals("Lightyears")) {
            meters = value * 9460730472580800.0;
        } else {
            throw new IllegalArgumentException("Invalid from unit: " + from);
        }

        if (to.equals("Meters")) {
            return meters;
        } else if (to.equals("Feet")) {
            return meters / 0.3048;
        } else if (to.equals("Inches")) {
            return meters / 0.0254;
        } else if (to.equals("Centimeters")) {
            return meters / 0.01;
        } else if (to.equals("Yards")) {
            return meters / 0.9144;
        } else if (to.equals("Lightyears")) {
            return meters / 9460730472580800.0;
        } else {
            throw new IllegalArgumentException("Invalid to unit: " + to);
        }

    }
}
