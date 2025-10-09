package com.jasonkp.converterkp.service;

import org.springframework.stereotype.Service;

@Service
public class TempCalcs implements  Converter {
    @Override
    public double convert(double value, String from, String to) {
        return value;
    }
}
