package com.jasonkp.converterkp.apis;

import com.jasonkp.converterkp.entities.ConversionHistory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

public interface HistoryApi {
    @GetMapping("/history")
    ResponseEntity<?> getHistory();

    @DeleteMapping("/history/clear")
    ResponseEntity<?> clearHistory();
}
