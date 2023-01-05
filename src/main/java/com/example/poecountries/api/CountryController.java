package com.example.poecountries.api;

import com.example.poecountries.business.CountryService;
import com.example.poecountries.dao.Country;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("api")
public class CountryController {

    @Autowired
    CountryService countryService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("games")
    public Country getGame(){
        Country country = countryService.getRandomCountry();

        // Conserve l'objet dans la Session HTTP
        httpSession.setAttribute("country", country);

        return country;
    }

    @PostMapping("games/{id}")
    public ResponseEntity<String> playGame(@PathVariable Integer id, @RequestBody GameResponseDTO playerResponse){
        Country country = (Country)httpSession.getAttribute("country");
        if(country == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veuillez démarrer une partie");
        } else {
            if(countryService.isCorrectAnswer(country, playerResponse.getCapital())){
                return ResponseEntity.ok("GAGNE");
            } else {
                return ResponseEntity.badRequest().body("PERDU");
            }
        }
    }
}
