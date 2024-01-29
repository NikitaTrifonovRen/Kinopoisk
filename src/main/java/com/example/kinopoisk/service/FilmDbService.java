package com.example.kinopoisk.service;

import com.example.kinopoisk.model.FilmDto;
import com.example.kinopoisk.model.FilmEntity;
import com.example.kinopoisk.model.FilmSearch;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmDbService {
    void addFilms(List<FilmEntity> films);
    FilmEntity findByKinopoiskId(Long kinopoiskId);

    List<FilmEntity> findByRatingKinopoiskBetweenAndYearBetween(
            double ratingFrom,
            double ratingTo,
            int yearFrom,
            int yearTo,
            Pageable pageable);

    List<FilmEntity> findByRatingKinopoiskBetweenAndYearBetweenAndNameRuContaining(
            double ratingFrom,
            double ratingTo,
            int yearFrom,
            int yearTo,
            String nameRu,
            Pageable pageable);
    List<FilmDto> getFilmsFromDb(FilmSearch params);
}
