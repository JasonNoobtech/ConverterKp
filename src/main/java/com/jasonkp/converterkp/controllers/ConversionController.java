package com.jasonkp.converterkp.controllers;

import com.jasonkp.converterkp.apis.ConversionApi;
import com.jasonkp.converterkp.dtos.ConversionRequestDto;
import com.jasonkp.converterkp.services.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @PostMapping("/convert")
    public ResponseEntity<?> convert(@RequestBody ConversionRequestDto request) {
        try {
            return conversionService.convert(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
