package com.jasonkp.converterkp.model;

public enum ConversionType {
    TEMPERATURE,
    WEIGHT,
    DISTANCE,
    CURRENCY,
    SPEED,
    DIGITAL_STORAGE;

    public static ConversionType fromString(String type) {
        String normalized = type.toUpperCase().replace(" ", "_");
        switch (normalized) {
            case "TEMPERATURE": return TEMPERATURE;
            case "WEIGHT": return WEIGHT;
            case "DISTANCE": return DISTANCE;
            case "CURRENCY": return CURRENCY;
            case "SPEED": return SPEED;
            case "DIGITAL_STORAGE": return DIGITAL_STORAGE;
            default: throw new IllegalArgumentException("Unsupported conversion type: " + type);
        }
    }
}