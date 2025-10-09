package com.jasonkp.converterkp.model;

import lombok.Data;

@Data
public class ConversionRequest {
    private ConversionType type;
    private double inputValue;
    private String to;
    private String from;
}
