package com.example.ormlearn.repository;

import com.example.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Facebook stock details in September 2019
    List<Stock> findByCodeAndDateBetween(
            String code,
            LocalDate startDate,
            LocalDate endDate);

    // 2. Google stocks where closing price > given value
    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            double close);

    // 3. Top 3 highest transaction volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. Lowest 3 Netflix stock prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}