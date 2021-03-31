package com.spring.clase3.star_wars.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {

    private String name;
    private List<String> matchingNames;

}
