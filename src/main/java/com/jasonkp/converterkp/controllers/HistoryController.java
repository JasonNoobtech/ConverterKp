package com.jasonkp.converterkp.controllers;

import com.jasonkp.converterkp.apis.HistoryApi;
import com.jasonkp.converterkp.entities.ConversionHistory;
import com.jasonkp.converterkp.repositories.HistoryRepository;
import com.jasonkp.converterkp.services.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController implements HistoryApi {

    private final HistoryService historyService;
    private final HistoryRepository historyRepository;

    public HistoryController(HistoryService historyService, HistoryRepository historyRepository) {
        this.historyService = historyService;
        this.historyRepository = historyRepository;
    }

    public ResponseEntity<List<ConversionHistory>> getHistory() {
        List<ConversionHistory> history = historyService.getAllHistory();
        return ResponseEntity.ok(history);
    }

    public ResponseEntity<?> clearHistory() {
        historyRepository.softDeleteAll(true);
        return ResponseEntity.ok("History cleared");
    }
}