package com.example.poecountries;

import com.example.poecountries.business.CountryService;
import com.example.poecountries.dao.Country;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountriesUnitTests {

    @Test
    void validateAnswer() {
       Country country = new Country();
       country.setName("France");
       country.setCapital("Paris");

        CountryService countryService = new CountryService();
        assertTrue(countryService.isCorrectAnswer(country, "Paris"));
        assertTrue(countryService.isCorrectAnswer(country, "paris"));
    }

}
