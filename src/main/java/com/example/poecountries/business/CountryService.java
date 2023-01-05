package com.example.poecountries.business;

import com.example.poecountries.dao.Country;
import com.example.poecountries.dao.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public Country getRandomCountry() {
        return countryRepository.findRandomCountry();
    }

    public boolean isCorrectAnswer(Country country, String playerAnswer) {
        if(playerAnswer.toLowerCase().equals(country.getCapital().toLowerCase())){
            return true;
        } else {
            return false;
        }
    }

    public Country getCountryById(Integer id){
        // TODO : vérifier si Optional non vide
        return countryRepository.findById(id).get();
    }
}
