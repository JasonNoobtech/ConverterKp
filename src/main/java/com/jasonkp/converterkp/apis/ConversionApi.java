package com.jasonkp.converterkp.apis;

import com.jasonkp.converterkp.dtos.ConversionRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ConversionApi {
    @PostMapping("/convert")
    ResponseEntity<?> convert(@RequestBody ConversionRequestDto request);
}
