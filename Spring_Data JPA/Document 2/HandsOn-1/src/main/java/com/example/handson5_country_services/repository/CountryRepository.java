package com.example.handson5_country_services.repository;

import com.example.handson5_country_services.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    // Existing method
    List<Country> findByNameContainingIgnoreCase(String name);

    // Hands-on 1 - Search by partial name
    List<Country> findByNameContaining(String text);

    // Hands-on 1 - Search by partial name in ascending order
    List<Country> findByNameContainingOrderByNameAsc(String text);

    // Hands-on 1 - Countries starting with a letter
    List<Country> findByNameStartingWith(String alphabet);
}