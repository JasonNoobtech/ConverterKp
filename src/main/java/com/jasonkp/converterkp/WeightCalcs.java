package com.jasonkp.converterkp;

import com.jasonkp.converterkp.service.Converter;
import org.springframework.stereotype.Service;

@Service
public class WeightCalcs implements Converter {
    @Override
    public double convert(double value, String from, String to) {
        return value;
    }
}
