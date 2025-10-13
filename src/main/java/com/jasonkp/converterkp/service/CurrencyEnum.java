package com.jasonkp.converterkp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public enum CurrencyEnum {
    DOLLAR("USD"),
    EURO("EUR"),
    POUND("GBP"),
    YUAN("CNY"),
    YEN("JPY"),
    RAND("ZAR"),
    NETHERLANDS_ANTILLEAN_GUILDER("ANG"),
    SOMALI_SHILLING("SOS"),
    ZIMBABWEAN_DOLLAR("ZWL"),
    ARMENIAN_DRAM("AMD");
    
    private final String code;
    private static final String API_KEY = "a0f2ad8ccc0354cb26e18d3b";
    private static Map<String, Double> rates;
    
    CurrencyEnum(String code) {
        this.code = code;
    }
    
    private static void fetchRates() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD"))
                .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode root = new ObjectMapper().readTree(response.body());
            rates = new ObjectMapper().convertValue(root.get("conversion_rates"), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch exchange rates: " + e.getMessage());
        }
    }
    
    public static CurrencyEnum fromString(String currency) {
        String normalized = currency.toUpperCase().replace(" ", "_");
        switch (normalized) {
            case "DOLLAR": return DOLLAR;
            case "EURO": return EURO;
            case "POUND": return POUND;
            case "YUAN": return YUAN;
            case "YEN": return YEN;
            case "RAND": return RAND;
            case "ZIMBABWEAN_DOLLAR": return ZIMBABWEAN_DOLLAR;
            case "ARMENIAN_DRAM": return ARMENIAN_DRAM;
            case "SOMALI_SHILLING": return SOMALI_SHILLING;
            case "NETHERLANDS_ANTILLEAN_GUILDER": return NETHERLANDS_ANTILLEAN_GUILDER;
            default: throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
    }
    
    public double convertTo(double value, CurrencyEnum toUnit) {
        if (this == toUnit) return value;
        
        if (rates == null) fetchRates();
        
        double fromRate = this == DOLLAR ? 1.0 : rates.get(this.code);
        double toRate = toUnit == DOLLAR ? 1.0 : rates.get(toUnit.code);
        
        return (value / fromRate) * toRate;
    }
}
