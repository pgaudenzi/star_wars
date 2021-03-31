package com.spring.clase3.star_wars.services;

import com.spring.clase3.star_wars.dtos.CharacterDto;
import com.spring.clase3.star_wars.dtos.ResponseDto;
import com.spring.clase3.star_wars.repositories.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    @Autowired
    StarWarsRepository repository;

    @Override
    public ResponseDto getCharactersWithSameName(String name) {
        List<CharacterDto> characters = repository.findCharactersByName(name);
        ResponseDto response = new ResponseDto();
        List<String> matchingNames = new ArrayList<>();
        response.setName(name);
        if (characters != null) {
            for (CharacterDto character : characters) {
                matchingNames.add(character.getName());
            }
            response.setMatchingNames(matchingNames);
        }
        return response;
    }
}
