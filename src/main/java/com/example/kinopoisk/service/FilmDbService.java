package com.example.kinopoisk.service;

import com.example.kinopoisk.model.Film;
import com.example.kinopoisk.repository.FilmDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmDbService {
    @Autowired
    private FilmDao filmDao;

    @Transactional
    public void addFilm(Film film) {
        filmDao.save(film);
    }

    @Transactional
    public void addFilms(List<Film> films) {
        filmDao.saveAll(films);
    }

    @Transactional
    public Film findByKinopoiskId(Long kinopoiskId) {
        return filmDao.findByKinopoiskId(kinopoiskId);
    }

    @Transactional
    public List<Film> findByNameRuContainingAndRatingKinopoiskBetweenAndYearBetweenAndKinopoiskId(String nameRu,
                                                                                                  double ratingFrom,
                                                                                                  double ratingTo,
                                                                                                  int yearFrom,
                                                                                                  int yearTo,
                                                                                                  Long kinopoiskId) {
        return filmDao.findByNameRuContainingAndRatingKinopoiskBetweenAndYearBetweenAndKinopoiskId(nameRu, ratingFrom,
                ratingTo, yearFrom, yearTo, kinopoiskId);
    }

    @Transactional
    public List<Film> findByNameRuContainingAndRatingKinopoiskBetweenAndYearBetween(String nameRu, Pageable pageable,
                                                                                    double ratingFrom,
                                                                                    double ratingTo,
                                                                                    int yearFrom,
                                                                                    int yearTo) {
        return filmDao.findByNameRuContainingAndRatingKinopoiskBetweenAndYearBetween(nameRu, pageable, ratingFrom,
                ratingTo, yearFrom, yearTo);
    }

    @Transactional
    public List<Film> findByRatingKinopoiskBetweenAndYearBetweenAndKinopoiskId(
            double ratingFrom,
            double ratingTo,
            int yearFrom,
            int yearTo,
            Long kinopoiskId) {
        return filmDao.findByRatingKinopoiskBetweenAndYearBetweenAndKinopoiskId(ratingFrom,
                ratingTo, yearFrom, yearTo, kinopoiskId);
    }
    @Transactional
    public List<Film> findByRatingKinopoiskBetweenAndYearBetween(
            double ratingFrom,
            double ratingTo,
            int yearFrom,
            int yearTo,
            Pageable pageable) {
        return filmDao.findByRatingKinopoiskBetweenAndYearBetween(ratingFrom,
                ratingTo, yearFrom, yearTo, pageable);
    }
}
