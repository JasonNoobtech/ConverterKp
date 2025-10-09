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

    final TempCalcs tempCalcs;
    final CurrencyCalcs currencyCalcs;
    final SpeedCalcs speedCalcs;
    final WeightCalcs weightCalcs;
    final LengthCalcs lengthCalcs;

    public ConversionController(TempCalcs tempCalcs,
                                CurrencyCalcs currencyCalcs,
                                SpeedCalcs speedCalcs,
                                WeightCalcs weightCalcs,
                                LengthCalcs lengthCalcs)
    {
        this.tempCalcs = tempCalcs;
        this.currencyCalcs = currencyCalcs;
        this.speedCalcs = speedCalcs;
        this.weightCalcs = weightCalcs;
        this.lengthCalcs = lengthCalcs;
    }

    @PostMapping("/convert")
    public ResponseEntity<?> convert(@RequestBody ConversionRequest request) {

        try {
            // Null request check
            if (request == null)
                return ResponseEntity.badRequest().body("Request body is required");
            // Validation for the correct type
            if (request.getType() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing conversion type");
            if (request.getTo() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing conversion to");
            if (request.getFrom() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing conversion from");

            double result;
            // Choose the correct converter
            if (request.getType() == ConversionType.TEMPERATURE) {
                result = tempCalcs.convert(request.getInputValue(), request.getFrom(), request.getTo());
            } else if (request.getType() == ConversionType.CURRENCY) {
                result = currencyCalcs.convert(request.getInputValue(), request.getFrom(), request.getTo());
            } else if (request.getType() == ConversionType.SPEED) {
                result = speedCalcs.convert(request.getInputValue(), request.getFrom(), request.getTo());
            } else if (request.getType() == ConversionType.WEIGHT) {
                result = weightCalcs.convert(request.getInputValue(), request.getFrom(), request.getTo());
            } else if (request.getType() == ConversionType.LENGTH) {
                result = lengthCalcs.convert(request.getInputValue(), request.getFrom(), request.getTo());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid conversion type");
            }
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid conversion parameters: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Conversion failed: " + e.getMessage());
        }
    }
}
