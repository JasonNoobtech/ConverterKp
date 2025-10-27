package com.jasonkp.converterkp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Entity
@Repository
@Data
@Table(name = "conversion_history")
public class ConversionHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "conversion_type")
    private String conversionType;
    
    @Column(name = "from_unit")
    private String fromUnit;
    
    @Column(name = "to_unit")
    private String toUnit;
    
    @Column(name = "input_value")
    private Double inputValue;
    
    @Column(name = "result_value")
    private Double resultValue;
    
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    
    @PrePersist
    protected void onCreate() {
        timestamp = LocalDateTime.now();
    }
}
