package com.spring.clase3.star_wars.services;

import com.spring.clase3.star_wars.dtos.ResponseDto;

public interface StarWarsService {

    ResponseDto getCharactersWithSameName(String name);

}
