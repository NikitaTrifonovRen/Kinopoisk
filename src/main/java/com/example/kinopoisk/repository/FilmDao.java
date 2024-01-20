package com.example.kinopoisk.repository;

import com.example.kinopoisk.model.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmDao extends JpaRepository<Film, Long> {
    Film findByKinopoiskId(Long kinopoiskId);
    List<Film> findByNameRuContainingAndRatingKinopoiskBetweenAndYearBetweenAndKinopoiskId(String nameRu,
                                                                                        double ratingFrom,
                                                                                        double ratingTo,
                                                                                        int yearFrom,
                                                                                        int yearTo,
                                                                                        Long kinopoiskId);
    List<Film> findByNameRuContainingAndRatingKinopoiskBetweenAndYearBetween(String nameRu,
                                                                                           double ratingFrom,
                                                                                           double ratingTo,
                                                                                           int yearFrom,
                                                                                           int yearTo);
    List<Film> findByRatingKinopoiskBetweenAndYearBetweenAndKinopoiskId(
                                                                                           double ratingFrom,
                                                                                           double ratingTo,
                                                                                           int yearFrom,
                                                                                           int yearTo,
                                                                                           Long kinopoiskId);
    List<Film> findByRatingKinopoiskBetweenAndYearBetween(
            double ratingFrom,
            double ratingTo,
            int yearFrom,
            int yearTo,
            Pageable pageable);

}
