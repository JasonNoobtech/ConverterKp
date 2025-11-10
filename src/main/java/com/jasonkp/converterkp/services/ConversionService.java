package com.jasonkp.converterkp.services;

import com.jasonkp.converterkp.dtos.ConversionRequestDto;
import com.jasonkp.converterkp.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    @Autowired
    private HistoryService historyService;

    public ResponseEntity<?> convert(ConversionRequestDto request) {
        validateRequest(request);

        try {
            double result;
            // Choose the correct converter
            switch (request.getType()) {
                case TEMPERATURE:
                    TempType fromTemp = TempType.fromString(request.getFrom());
                    TempType toTemp = TempType.fromString(request.getTo());
                    result = fromTemp.convertTo(request.getInputValue(), toTemp);
                    break;
                case CURRENCY:
                    CurrencyType fromCurrency = CurrencyType.fromString(request.getFrom());
                    CurrencyType toCurrency = CurrencyType.fromString(request.getTo());
                    result = fromCurrency.convertTo(request.getInputValue(), toCurrency);
                    break;
                case WEIGHT:
                    WeightType fromWeight = WeightType.fromString(request.getFrom());
                    WeightType toWeight = WeightType.fromString(request.getTo());
                    result = fromWeight.convertTo(request.getInputValue(), toWeight);
                    break;
                case DISTANCE:
                    DistanceType fromDistance = DistanceType.fromString(request.getFrom());
                    DistanceType toDistance = DistanceType.fromString(request.getTo());
                    result = fromDistance.convertTo(request.getInputValue(), toDistance);
                    break;
                case DIGITAL_STORAGE:
                    StorageType fromStorage = StorageType.fromString(request.getFrom());
                    StorageType toStorage = StorageType.fromString(request.getTo());
                    result = fromStorage.convertTo(request.getInputValue(), toStorage);
                    break;
                case CELESTIAL_BODIES:
                    CelestialType fromPlanet = CelestialType.fromString(request.getFrom());
                    CelestialType toPlanet = CelestialType.fromString(request.getTo());
                    result = fromPlanet.convertTo(request.getInputValue(), toPlanet);
                    break;
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid conversion type");
            }

            result = Math.round(result * 100.0) / 100.0;
            historyService.save(request, result);

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    private void validateRequest(ConversionRequestDto request) {
        if (request.getType() == null) {
            throw new IllegalArgumentException("Missing conversion type");
        }
        if (request.getFrom() == null || request.getFrom().trim().isEmpty()) {
            throw new IllegalArgumentException("Missing 'from' unit");
        }
        if (request.getTo() == null || request.getTo().trim().isEmpty()) {
            throw new IllegalArgumentException("Missing 'to' unit");
        }
    }
}
