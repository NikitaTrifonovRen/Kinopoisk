package com.example.kinopoisk.repository;

import com.example.kinopoisk.model.FilmEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
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


}
