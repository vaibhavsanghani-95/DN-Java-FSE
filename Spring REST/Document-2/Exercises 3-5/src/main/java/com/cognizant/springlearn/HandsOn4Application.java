package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")
public class HandsOn4Application{

    public static void main(String[] args) {
        SpringApplication.run(HandsOn4Application.class, args);
    }
}