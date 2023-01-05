package com.example.poecountries.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country,Integer> {

    @Query(value="SELECT * FROM countries ORDER BY RANDOM() LIMIT 1", nativeQuery=true)
    public Country findRandomCountry();
}