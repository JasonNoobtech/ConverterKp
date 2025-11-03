package com.jasonkp.converterkp.services;

import com.jasonkp.converterkp.dtos.ConversionRequestDto;
import com.jasonkp.converterkp.entities.ConversionHistory;
import com.jasonkp.converterkp.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public void save(ConversionRequestDto request, double result) {
        ConversionHistory conversionHistory = new ConversionHistory();
        conversionHistory.setConversionType(request.getType().toString());
        conversionHistory.setFromUnit(request.getFrom());
        conversionHistory.setToUnit(request.getTo());
        conversionHistory.setInputValue(request.getInputValue());
        conversionHistory.setResultValue(result);
        conversionHistory.setDeleted(false);

        historyRepository.save(conversionHistory);
    }

    public List<ConversionHistory> getAllHistory() {
        return historyRepository.findAllActiveHistory();
    }

}
