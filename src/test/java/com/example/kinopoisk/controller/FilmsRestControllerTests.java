package com.example.kinopoisk.controller;


import com.example.kinopoisk.mapper.FilmsMapper;
import com.example.kinopoisk.model.FilmDto;
import com.example.kinopoisk.model.FilmEntity;
import com.example.kinopoisk.model.FilmSearch;
import com.example.kinopoisk.service.FilmDbServiceImpl;
import com.example.kinopoisk.service.FilmSearchServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = FilmsRestController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class FilmsRestControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FilmDbServiceImpl filmDbService;
    @MockBean
    private FilmSearchServiceImpl filmSearchService;

    @MockBean
    private FilmsMapper filmsMapper;
    FilmEntity film = new FilmEntity();
    FilmEntity film1 = new FilmEntity();
    List<FilmEntity> films = new ArrayList<>();
    FilmSearch filmSearch = new FilmSearch();
    List<FilmDto> filmDtos = new ArrayList<>();

    @BeforeEach
    public void init(){
        film.setYear(1999);
        film.setKinopoiskId(2L);
        film.setId(1L);

        film1.setNameRu("Fight");
        film1.setYear(1999);
        film1.setKinopoiskId(3L);
        film1.setId(4L);

        films.add(film);
        films.add(film1);

        filmSearch.setYearFrom(1999);
        filmSearch.setYearTo(1999);
        filmDtos = filmsMapper.toDtos(films);
    }
    @Test
    public void FilmsRestController_GetALL_ReturnResponseEntity() throws Exception {
        when(filmDbService.getFilmsFromDb(filmSearch)).thenReturn(filmDtos);
        ResultActions resultActions = mockMvc.perform(get("/films/base")
                .content(objectMapper.writeValueAsString(filmSearch))
                .contentType(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());


    }
    @Test
    public void FilmsRestController_SearchAll_ReturnResponseEntitry() throws Exception{
        when(filmSearchService.getFilms(filmSearch)).thenReturn(filmDtos);
        ResultActions resultActions = mockMvc.perform(post("/films/search")
                .content(objectMapper.writeValueAsString(filmSearch))
                .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());


    }


}
