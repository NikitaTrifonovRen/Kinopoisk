package com.example.kinopoisk.service;

import com.example.kinopoisk.mapper.FilmsMapper;
import com.example.kinopoisk.model.FilmDto;
import com.example.kinopoisk.model.FilmEntity;
import com.example.kinopoisk.model.FilmSearch;
import com.example.kinopoisk.repository.FilmRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmDbServiceImpl implements FilmDbService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmsMapper filmsMapper;
    @Transactional
    public List<FilmEntity> addFilms(List<FilmEntity> films) {
        return filmRepository.saveAll(films);
    }
    @Transactional
    public FilmEntity findByKinopoiskId(Long kinopoiskId) {
        return filmRepository.findByKinopoiskId(kinopoiskId);
    }
    @Transactional
    public List<FilmEntity> findByRatingKinopoiskBetweenAndYearBetween(
            double ratingFrom,
            double ratingTo,
            int yearFrom,
            int yearTo,
            Pageable pageable) {
        return filmRepository.findByRatingKinopoiskBetweenAndYearBetween(ratingFrom,
                ratingTo, yearFrom, yearTo, pageable);
    }

    @Transactional
    public List<FilmEntity> findByRatingKinopoiskBetweenAndYearBetweenAndNameRuContaining(
            double ratingFrom,
            double ratingTo,
            int yearFrom,
            int yearTo,
            String nameRu,
            Pageable pageable){
        return filmRepository.findByRatingKinopoiskBetweenAndYearBetweenAndNameRuContaining(ratingFrom,ratingTo,yearFrom,yearTo,nameRu,pageable);
    }
    @Transactional
    public List<FilmDto> getFilmsFromDb(FilmSearch params){
        List<FilmEntity> DbFilms;
        List<FilmDto> DbFilmsToShow;
        Optional<String> checkKeyword = Optional.ofNullable(params.getKeyword());
        Optional<Integer> checkPage = Optional.ofNullable(params.getPage());
        Optional<String> checkOrder = Optional.ofNullable(params.getOrder());
        Integer page = 0;
        String order = "ratingKinopoisk";

        if (checkPage.isPresent()){
            page = params.getPage();
        }
        if (checkOrder.isPresent()){
            order = params.getOrder();
        }
        Pageable pageable = PageRequest.of(page, 20, Sort.by(order).descending());

        Optional<Double> checkRatingFrom = Optional.ofNullable(params.getRatingFrom());
        Optional<Double> checkRatingTo = Optional.ofNullable(params.getRatingTo());
        Optional<Integer> checkYearFrom = Optional.ofNullable(params.getYearFrom());
        Optional<Integer> checkYearTo = Optional.ofNullable(params.getYearTo());
        Double ratingFrom = 0.0;
        Double ratingTo = 10.0;
        Integer yearFrom = 0;
        Integer yearTo = 3000;
        String nameRu = "";
        if (checkRatingFrom.isPresent()){
            ratingFrom = params.getRatingFrom();
        }
        if (checkRatingTo.isPresent()){
            ratingTo = params.getRatingTo();
        }
        if (checkYearFrom.isPresent()){
            yearFrom = params.getYearFrom();
        }
        if (checkYearTo.isPresent()){
            yearTo = params.getYearTo();
        }
        if (checkKeyword.isPresent()){
            nameRu = params.getKeyword();
        }

        if(checkKeyword.isPresent()){
            DbFilms = filmRepository.findByRatingKinopoiskBetweenAndYearBetweenAndNameRuContaining(ratingFrom,
                    ratingTo,yearFrom,yearTo,nameRu,pageable);
        }
        else {
            DbFilms = filmRepository.findByRatingKinopoiskBetweenAndYearBetween(ratingFrom,ratingTo,yearFrom,yearTo,pageable);
        }
        DbFilmsToShow = filmsMapper.toDtos(DbFilms);

        return  DbFilmsToShow;
    }
}
