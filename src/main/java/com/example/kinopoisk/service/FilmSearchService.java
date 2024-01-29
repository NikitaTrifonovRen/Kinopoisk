package com.example.kinopoisk.service;

import com.example.kinopoisk.model.FilmDto;
import com.example.kinopoisk.model.FilmSearch;
import jakarta.xml.bind.JAXBException;

import java.util.List;

public interface FilmSearchService {
    List<FilmDto> getFilms(FilmSearch params);
    List<FilmDto> saveNewFilms(FilmSearch params) throws JAXBException;
}
