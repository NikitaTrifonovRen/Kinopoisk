package com.example.kinopoisk;

import com.example.kinopoisk.controller.FilmsRestController;
import com.example.kinopoisk.model.FilmSearch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

class KinopoiskApplicationTests {

    @Autowired
    private FilmsRestController filmsRestController;
    FilmSearch filmSearch = new FilmSearch();


    @Test
    public void contextLoads() throws Exception {
        assertThat(filmsRestController).isNotNull();
    }
    @Test
    public void restTestDb() throws Exception{
        filmSearch.setKeyword("зел");
        assertThat(filmsRestController.showFilmInDb(filmSearch)).isNotEmpty();
    }
    @Test
    public void restTestResponse() throws Exception{
        filmSearch.setPage(1);
        assertThat(filmsRestController.getFilms(filmSearch)).isNotEqualTo(HttpStatus.BAD_REQUEST);
    }



}
