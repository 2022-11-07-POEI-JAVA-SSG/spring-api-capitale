package com.example.poecountries;

import com.example.poecountries.dao.Country;
import com.example.poecountries.dao.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PoeCountriesApplicationTests {

    @Autowired
    CountryRepository countryRepository;

    @Test
    void loadCountries() {
        List<Country> countries = countryRepository.findAll();
        for(Country country : countries){
            System.out.println(country);
        }

    }

}
