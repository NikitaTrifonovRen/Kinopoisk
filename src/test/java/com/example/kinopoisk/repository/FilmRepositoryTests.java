package com.example.kinopoisk.repository;

import com.example.kinopoisk.model.FilmEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FilmRepositoryTests {
    @Autowired
    private FilmRepository filmRepository;
    @Test
    public void FilmRepository_SaveAll_ReturnSavedFilm(){
        //Arrange
        FilmEntity film = new FilmEntity();
        film.setYear(1999);
        film.setKinopoiskId(2L);
        //Act
        FilmEntity savedFilm = filmRepository.save(film);
        //Assert
        Assertions.assertThat(savedFilm).isNotNull();
        Assertions.assertThat(savedFilm.getYear()).isGreaterThan(1998);
    }
    @Test
    public void FilmRepository_GetAll_ReturnMoreThanOneFilm(){
        //Arrange
        FilmEntity film = new FilmEntity();
        film.setYear(1999);
        film.setKinopoiskId(2L);
        film.setId(1L);
        FilmEntity film1 = new FilmEntity();
        film1.setNameRu("Fight");
        film1.setYear(1999);
        film1.setKinopoiskId(3L);
        film1.setId(4L);

        //Act
        FilmEntity savedFilm = filmRepository.save(film);
        FilmEntity savedFilm1 = filmRepository.save(film1);
        List<FilmEntity> filmList = filmRepository.findAll();
        //Assert
        Assertions.assertThat(filmList).isNotEmpty();
        Assertions.assertThat(filmList).isNotNull();
        Assertions.assertThat(filmList).contains(savedFilm1);
    }
    @Test
    public void FilmRepository_ReturnMoreThanOneFilm(){
        FilmEntity film = new FilmEntity();
        film.setYear(1999);
        film.setKinopoiskId(2L);
        film.setId(1L);
        film.setNameRu("12345");

        FilmEntity savedFilm = filmRepository.save(film);

        List<FilmEntity> filmList = filmRepository.findByRatingKinopoiskBetweenAndYearBetweenAndNameRuContaining(
                0,10,0,3000,"12345", PageRequest.of(0,20));
        Assertions.assertThat(filmList).isNotEmpty();
        Assertions.assertThat(filmList).isNotNull();

    }


}
