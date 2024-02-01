package com.example.kinopoisk.service;

import com.example.kinopoisk.model.FilmEntity;
import com.example.kinopoisk.repository.FilmRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FilmDbServiceTests {

    @Mock
    private FilmRepository filmRepository;

    @InjectMocks
    private FilmDbServiceImpl filmDbService;

    @Test
    public void FilmDbService_SaveAll_ReturnFilms(){
        FilmEntity film = new FilmEntity();
        film.setYear(1999);
        film.setKinopoiskId(2L);
        film.setId(1L);
        FilmEntity film1 = new FilmEntity();
        film1.setNameRu("Fight");
        film1.setYear(1999);
        film1.setKinopoiskId(3L);
        film1.setId(4L);
        FilmEntity film2 = new FilmEntity();
        film1.setNameRu("Fighta");
        film1.setYear(1999);
        film1.setKinopoiskId(7L);
        film1.setId(8L);

        List<FilmEntity> films = new ArrayList<>();
        films.add(film);
        films.add(film1);
        List<FilmEntity> fakeFilms = new ArrayList<>();
        fakeFilms.add(film);
        fakeFilms.add(film2);

        when(filmRepository.saveAll(Mockito.anyList())).thenReturn(films);

        List<FilmEntity> savedFilms = filmDbService.addFilms(films);
        Assertions.assertThat(savedFilms).isNotEmpty();
        Assertions.assertThat(savedFilms).isNotNull();
        Assertions.assertThat(savedFilms).isNotEqualTo(fakeFilms);
        Assertions.assertThat(savedFilms).isEqualTo(films);



    }


}
