package com.spring.clase3.star_wars.controllers;

import com.spring.clase3.star_wars.dtos.ResponseDto;
import com.spring.clase3.star_wars.services.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {

    @Autowired
    private StarWarsService service;

    @GetMapping("/getCharacters/{name}")
    public ResponseDto getCharacters(@PathVariable String name) {
        return service.getCharactersWithSameName(name);
    }

}
