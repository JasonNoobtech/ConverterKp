package com.jasonkp.converterkp.repositories;

import com.jasonkp.converterkp.entities.ConversionHistory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<ConversionHistory, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE ConversionHistory h SET h.deleted = :deleted WHERE h.deleted = false OR h.deleted IS NULL")
    void softDeleteAll(boolean deleted);

    @Query("SELECT h FROM ConversionHistory h WHERE h.deleted = false OR h.deleted IS NULL ORDER BY h.timestamp DESC")
    List<ConversionHistory> findAllActiveHistory();

}
