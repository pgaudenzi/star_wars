package com.spring.clase3.star_wars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.clase3.star_wars.dtos.CharacterDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {

    @Override
    public List<CharacterDto> findCharactersByName(String name) {
        List<CharacterDto> characters = loadDatabase();
        List<CharacterDto> result = null;
        if (characters != null) {
            result = characters.stream()
                    .filter(character -> character.getName().contains(name))
                    .collect(Collectors.toList());
        }
        return result;
    }

    private List<CharacterDto> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDto>> typeReference = new TypeReference<List<CharacterDto>>() {};
        List<CharacterDto> characters = new ArrayList<>();
        try {
            characters = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return characters;
    }

}
