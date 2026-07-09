package com.example.ormlearn;

import com.example.ormlearn.repository.StockRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class HandsOn2Application{

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(HandsOn2Application.class, args);

        StockRepository repository = context.getBean(StockRepository.class);

        // 1. Facebook stocks in September 2019
        System.out.println("===== Facebook Stocks (September 2019) =====");
        repository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        ).forEach(System.out::println);

        // 2. Google stocks with closing price > 1250
        System.out.println("\n===== Google Stocks (Close > 1250) =====");
        repository.findByCodeAndCloseGreaterThan("GOOGL", 1250)
                .forEach(System.out::println);

        // 3. Top 3 highest volume transactions
        System.out.println("\n===== Top 3 Highest Volume =====");
        repository.findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);

        // 4. Lowest 3 Netflix stock prices
        System.out.println("\n===== Lowest 3 Netflix Stocks =====");
        repository.findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);
    }
}