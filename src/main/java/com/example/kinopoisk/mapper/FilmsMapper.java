package com.example.kinopoisk.mapper;

import com.example.kinopoisk.model.FilmDto;
import com.example.kinopoisk.model.FilmEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmsMapper {
    List<FilmEntity> toEntities(List<FilmDto> filmDtos);
    List<FilmDto> toDtos(List<FilmEntity> filmEntities);
}
