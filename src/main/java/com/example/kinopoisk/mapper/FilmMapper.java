package com.example.kinopoisk.mapper;


import com.example.kinopoisk.model.FilmDto;
import com.example.kinopoisk.model.FilmEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {
    FilmEntity toEntity(FilmDto filmDto);
    FilmDto toDto(FilmEntity filmEntity);
}
