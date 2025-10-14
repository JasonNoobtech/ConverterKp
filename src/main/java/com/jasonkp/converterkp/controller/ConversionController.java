package com.jasonkp.converterkp.controller;

import com.jasonkp.converterkp.model.ConversionRequest;
import com.jasonkp.converterkp.model.ConversionType;
import com.jasonkp.converterkp.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ConversionController {

    @PostMapping("/convert")
    public ResponseEntity<?> convert(@RequestBody ConversionRequest request) {
        
        // Validate request
        if (request.getType() == null) {
            return ResponseEntity.badRequest().body("Missing conversion type");
        }
        if (request.getFrom() == null || request.getFrom().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Missing 'from' unit");
        }
        if (request.getTo() == null || request.getTo().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Missing 'to' unit");
        }

        try {
            double result;
            // Choose the correct converter
            if (request.getType() == ConversionType.TEMPERATURE) {
                TempEnum fromUnit = TempEnum.fromString(request.getFrom());
                TempEnum toUnit = TempEnum.fromString(request.getTo());
                result = fromUnit.convertTo(request.getInputValue(), toUnit);
            } else if (request.getType() == ConversionType.CURRENCY) {
                CurrencyEnum fromUnit = CurrencyEnum.fromString(request.getFrom());
                CurrencyEnum toUnit = CurrencyEnum.fromString(request.getTo());
                result = fromUnit.convertTo(request.getInputValue(), toUnit);
            } else if (request.getType() == ConversionType.WEIGHT) {
                WeightEnum fromUnit = WeightEnum.fromString(request.getFrom());
                WeightEnum toUnit = WeightEnum.fromString(request.getTo());
                result = fromUnit.convertTo(request.getInputValue(), toUnit);
            } else if (request.getType() == ConversionType.DISTANCE) {
                DistanceEnum fromUnit = DistanceEnum.fromString(request.getFrom());
                DistanceEnum toUnit = DistanceEnum.fromString(request.getTo());
                result = fromUnit.convertTo(request.getInputValue(), toUnit);
            } else if (request.getType() == ConversionType.DIGITAL_STORAGE) {
                StorageEnum fromUnit = StorageEnum.fromString(request.getFrom());
                StorageEnum toUnit = StorageEnum.fromString(request.getTo());
                result = fromUnit.convertTo(request.getInputValue(), toUnit);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid conversion type");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
