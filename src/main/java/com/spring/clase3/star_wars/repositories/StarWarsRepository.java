package com.spring.clase3.star_wars.repositories;

import com.spring.clase3.star_wars.dtos.CharacterDto;
import com.spring.clase3.star_wars.dtos.ResponseDto;

import java.util.List;

public interface StarWarsRepository {

    List<CharacterDto> findCharactersByName(String name);

}
