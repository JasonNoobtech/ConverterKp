package com.jasonkp.converterkp.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyCalcs implements Converter {
    @Override
    public double convert(double value, String from, String to) {

        if (from.equals(to)) {
            return value;
        }

        double rand;
        if (from.equals("Rand")) {
            rand = value;
        } else if (from.equals("EUR")) {
            rand = value * 0.050;
        } else if (from.equals("GBP")) {
            rand = value * 0.044;
        } else if (from.equals("JPY")) {
            rand = value * 8.92;
        } else if (from.equals("CAD")) {
            rand = value * 0.082;
        } else if (from.equals("USD")) {
            rand = value * 0.058;
        } else {
            throw new IllegalArgumentException("Invalid from unit: " + from);
        }

        if (to.equals("Rand")) {
            return rand;
        } else if (to.equals("EUR")) {
            return rand / 0.050;
        } else if (to.equals("GBP")) {
            return rand / 0.044;
        } else if (to.equals("JPY")) {
            return rand / 8.92;
        } else if (to.equals("CAD")) {
            return rand / 0.082;
        } else if (to.equals("USD")) {
            return rand / 0.058;
        } else {
            throw new IllegalArgumentException("Invalid to unit: " + to);
        }
    }
}
