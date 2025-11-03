package com.jasonkp.converterkp.dtos;

import com.jasonkp.converterkp.enums.ConversionType;
import lombok.Data;

@Data
public class ConversionRequestDto {
    private ConversionType type;
    private double inputValue;
    private String to;
    private String from;
}
