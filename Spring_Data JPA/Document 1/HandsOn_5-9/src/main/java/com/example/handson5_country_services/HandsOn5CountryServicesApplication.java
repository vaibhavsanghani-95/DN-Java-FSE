package com.example.handson5_country_services;

import com.example.handson5_country_services.model.Country;
import com.example.handson5_country_services.service.CountryService;
import com.example.handson5_country_services.service.exception.CountryNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HandsOn5CountryServicesApplication {

    public static void main(String[] args) throws CountryNotFoundException {
        ApplicationContext context =
                SpringApplication.run(HandsOn5CountryServicesApplication.class, args);

        CountryService countryService = context.getBean(CountryService.class);

        // Find
        Country country = countryService.findCountryByCode("IN");
        System.out.println(country);

        // Add
        countryService.addCountry(new Country("AA", "My Country"));

        // Update
        countryService.updateCountry("AA", "Updated Country");

        // Search
        System.out.println(countryService.searchCountry("land"));

        // Delete
        countryService.deleteCountry("AA");
    }
}