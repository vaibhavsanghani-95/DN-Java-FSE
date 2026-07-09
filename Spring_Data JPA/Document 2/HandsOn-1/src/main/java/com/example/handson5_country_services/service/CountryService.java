package com.example.handson5_country_services.service;

import com.example.handson5_country_services.service.exception.CountryNotFoundException;
import com.example.handson5_country_services.model.Country;
import com.example.handson5_country_services.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    // Find by code
    @Transactional
    public Country findCountryByCode(String code) throws CountryNotFoundException {

        Optional<Country> result = repository.findById(code);

        if (result.isEmpty()) {
            throw new CountryNotFoundException("Country with code " + code + " not found.");
        }

        return result.get();
    }

    // Add
    @Transactional
    public void addCountry(Country country) {
        repository.save(country);
    }

    // Update
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {

        Optional<Country> result = repository.findById(code);

        if (result.isEmpty()) {
            throw new CountryNotFoundException("Country with code " + code + " not found.");
        }

        Country country = result.get();
        country.setName(name);

        repository.save(country);
    }

    // Delete
    @Transactional
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

    // Search by partial name
    @Transactional
    public List<Country> searchCountry(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public List<Country> searchCountries(String text) {
        return repository.findByNameContaining(text);
    }

    @Transactional
    public List<Country> searchCountriesSorted(String text) {
        return repository.findByNameContainingOrderByNameAsc(text);
    }

    @Transactional
    public List<Country> getCountriesStartingWith(String alphabet) {
        return repository.findByNameStartingWith(alphabet);
    }
}