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

        // Find Country
        Country country = countryService.findCountryByCode("IN");

        // Add Country
        countryService.addCountry(new Country("AA", "My Country"));

        // Update Country
        countryService.updateCountry("AA", "Updated Country");

        // Search Country (existing method)
        countryService.searchCountry("land")
                .forEach(System.out::println);

        // Query Method 1: Contains
        countryService.searchCountries("ou")
                .forEach(System.out::println);

        // Query Method 2: Contains + Order By
        countryService.searchCountriesSorted("ou")
                .forEach(System.out::println);

        // Query Method 3: Starts With
        countryService.getCountriesStartingWith("Z")
                .forEach(System.out::println);

        // Delete Country
        countryService.deleteCountry("AA");
        System.out.println("Country AA deleted successfully.");
    }
}
