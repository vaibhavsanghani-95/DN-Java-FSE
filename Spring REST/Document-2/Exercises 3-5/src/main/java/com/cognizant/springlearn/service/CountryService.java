package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.model.CountryList;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryList countryList;

    // Return all countries
    public List<Country> getAllCountries() {
        return countryList.getCountryList();
    }

    // Return country by code
    public Country getCountry(String code) throws CountryNotFoundException {

        return countryList.getCountryList()
                .stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);
    }
}