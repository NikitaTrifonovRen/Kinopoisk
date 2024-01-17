package com.example.kinopoisk.controller;

import com.example.kinopoisk.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")

public class FilmsRestController {
    @Autowired
    private FilmService filmService;
    @GetMapping
    public ResponseEntity getAllFilms(){
        return new ResponseEntity<>(filmService.getAllFilms().getItems(),HttpStatus.OK);
    }



}
