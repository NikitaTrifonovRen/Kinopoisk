package com.example.kinopoisk;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

class KinopoiskApplicationTests {
    @Test
    public void contextLoads(){

    }

//    @Autowired
//    private FilmsRestController filmsRestController;
//    FilmSearch filmSearch = new FilmSearch();
//
//
//    @Test
//    public void contextLoads() throws Exception {
//        assertThat(filmsRestController).isNotNull();
//    }
//    @Test
//    public void restTestDb() throws Exception{
//        filmSearch.setKeyword("зел");
//        assertThat(filmsRestController.showFilmInDb(filmSearch)).isNotEmpty();
//    }
//    @Test
//    public void restTestResponse() throws Exception{
//        filmSearch.setPage(1);
//        assertThat(filmsRestController.getFilms(filmSearch)).isNotEqualTo(HttpStatus.BAD_REQUEST);
//    }



}
