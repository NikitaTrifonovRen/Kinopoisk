package com.example.kinopoisk.controller;

import com.example.kinopoisk.model.Film;
import com.example.kinopoisk.model.Films;
import com.example.kinopoisk.service.FilmDbService;
import com.example.kinopoisk.service.FilmSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")

public class FilmsRestController {
    @Autowired
    private FilmSearchService filmSearchService;
    @Autowired
    private FilmDbService filmDbService;
    @GetMapping
    public ResponseEntity getAllFilms(){
        List<Film> filmList = filmSearchService.getAllFilms().getItems();
        filmList.stream()
                .filter(film -> filmDbService.findByKinopoiskId(film.getKinopoiskId()) == null)
                .forEach(film -> filmDbService.addFilm(film));

        return new ResponseEntity<>(filmList,HttpStatus.OK);
    }
    @GetMapping(value = "/search")
    public ResponseEntity getFilms(@RequestParam(value = "c",defaultValue = "")String countries,
                                   @RequestParam(value = "g",defaultValue = "")String genres,
                                   @RequestParam(value = "o",defaultValue = "RATING")String order,
                                   @RequestParam(value = "t",defaultValue = "ALL")String type,
                                   @RequestParam(value = "rF",defaultValue = "0")String ratingFrom,
                                   @RequestParam(value = "rT",defaultValue = "10")String ratingTo,
                                   @RequestParam(value = "yF",defaultValue = "")String yearFrom,
                                   @RequestParam(value = "yT",defaultValue = "")String yearTo,
                                   @RequestParam(value = "i",defaultValue = "")String imdbId,
                                   @RequestParam(value = "k",defaultValue = "")String keyword,
                                   @RequestParam(value = "p",defaultValue = "1")String page){
        List<Film> filmList = filmSearchService.getFilms(countries,genres,order,type,ratingFrom,
                ratingTo,yearFrom,yearTo,imdbId,keyword,page).getItems();
        filmList.stream()
                .filter(film -> filmDbService.findByKinopoiskId(film.getKinopoiskId()) == null)
                .forEach(film -> filmDbService.addFilm(film));

        return new ResponseEntity<>(filmList,HttpStatus.OK);
    }
    @GetMapping(value = "/base")
    public List<Film> showFilmInDb(@RequestParam(value = "o",defaultValue = "ratingKinopoisk")String order,
                                   @RequestParam(value = "pS",defaultValue = "1") int pageSize,
                                   @RequestParam(value = "rF",defaultValue = "0")double ratingFrom,
                                   @RequestParam(value = "rT",defaultValue = "10")double ratingTo,
                                   @RequestParam(value = "yF",defaultValue = "0")int yearFrom,
                                   @RequestParam(value = "yT",defaultValue = "3000")int yearTo,
                                   @RequestParam(value = "i",required = false)Long kinopoiskId,
                                   @RequestParam(value = "k",required = false)String keyword,
                                   @RequestParam(value = "p",defaultValue = "1")int page){
        List<Film> DbFilms;
        Optional<Long> checkId = Optional.ofNullable(kinopoiskId);
        Optional<String> checkKeyword = Optional.ofNullable(keyword);
        Pageable pageable = PageRequest.of(page,pageSize, Sort.by(order).descending());

        if(checkId.isPresent() & checkKeyword.isPresent()) {

            DbFilms = filmDbService.findByNameRuContainingAndRatingKinopoiskBetweenAndYearBetweenAndKinopoiskId(keyword,
                    ratingFrom, ratingTo, yearFrom, yearTo, kinopoiskId);
        }
        else if(checkId.isPresent()){
            DbFilms = filmDbService.findByRatingKinopoiskBetweenAndYearBetweenAndKinopoiskId(ratingFrom,
                    ratingTo, yearFrom, yearTo, kinopoiskId);
        }
        else if(checkKeyword.isPresent()){
            DbFilms = filmDbService.findByNameRuContainingAndRatingKinopoiskBetweenAndYearBetween(keyword, pageable,
                    ratingFrom,ratingTo,yearFrom,yearTo);
        }
        else {
            DbFilms = filmDbService.findByRatingKinopoiskBetweenAndYearBetween(ratingFrom,ratingTo,yearFrom,yearTo,
                    pageable);
        }
        return  DbFilms;
    }
}
