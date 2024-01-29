package com.example.kinopoisk.controller;

import com.example.kinopoisk.model.FilmDto;
import com.example.kinopoisk.model.FilmSearch;
import com.example.kinopoisk.service.FilmDbServiceImpl;
import com.example.kinopoisk.service.FilmSearchServiceImpl;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")

public class FilmsRestController {
    @Autowired
    private FilmSearchServiceImpl filmSearchServiceImpl;
    @Autowired
    private FilmDbServiceImpl filmDbServiceImpl;

    @PostMapping(value = "/search")
    public ResponseEntity getFilms(@RequestBody FilmSearch params) {
        return new ResponseEntity<>(filmSearchServiceImpl.getFilms(params),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity saveNewFilm(@RequestBody FilmSearch params) throws JAXBException {
        return new ResponseEntity<>(filmSearchServiceImpl.saveNewFilms(params),HttpStatus.OK);
    }

    @GetMapping(value = "/base")
    public List<FilmDto> showFilmInDb(@RequestBody FilmSearch params){
        return filmDbServiceImpl.getFilmsFromDb(params);
    }
}
