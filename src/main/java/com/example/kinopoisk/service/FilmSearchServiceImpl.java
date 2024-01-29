package com.example.kinopoisk.service;

import com.example.kinopoisk.mapper.FilmsMapper;
import com.example.kinopoisk.model.FilmDto;
import com.example.kinopoisk.model.FilmEntity;
import com.example.kinopoisk.model.FilmSearch;
import com.example.kinopoisk.model.Films;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmSearchServiceImpl implements FilmSearchService {

    @Autowired
    private FilmsMapper filmsMapper;

    @Autowired
    private FilmDbServiceImpl filmDbServiceImpl;
    @Autowired
    private MailServiceImpl mailServiceImpl;
    private RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    private static final String kpApi =
            "https://kinopoiskapiunofficial.tech/api/v2.2/films";
    public List<FilmDto> getFilms(FilmSearch params){
        UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https")
                .host("kinopoiskapiunofficial.tech/api/v2.2/films")
                .queryParamIfPresent("countries",Optional.ofNullable(params.getCountries()))
                .queryParamIfPresent("genres",Optional.ofNullable(params.getGenres()))
                .queryParamIfPresent("order",Optional.ofNullable(params.getOrder()))
                .queryParamIfPresent("type",Optional.ofNullable(params.getType()))
                .queryParamIfPresent("ratingFrom",Optional.ofNullable(params.getRatingFrom()))
                .queryParamIfPresent("ratingTo",Optional.ofNullable(params.getRatingTo()))
                .queryParamIfPresent("yearFrom",Optional.ofNullable(params.getYearFrom()))
                .queryParamIfPresent("yearTo",Optional.ofNullable(params.getYearTo()))
                .queryParamIfPresent("imdbId",Optional.ofNullable(params.getImdbId()))
                .queryParamIfPresent("keyword",Optional.ofNullable(params.getKeyword()))
                .queryParamIfPresent("page",Optional.ofNullable(params.getPage()))
                .build();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-API-KEY","06c25e47-c7a4-439f-beed-ea885b782d39");
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, entity,Films.class).getBody().getItems();
    }
    public List<FilmDto> saveNewFilms(FilmSearch params) throws JAXBException {

        List<FilmEntity> entitiesFilms = filmsMapper.toEntities(getFilms(params));
        List<FilmEntity> filteredFilms = entitiesFilms.stream()
                .filter(film -> filmDbServiceImpl.findByKinopoiskId(film.getKinopoiskId()) == null)
                .collect(Collectors.toList());
        filmDbServiceImpl.addFilms(filteredFilms);
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Films.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        List<FilmDto> films = filmsMapper.toDtos(filteredFilms);
        Films xmlFilms = new Films();
        xmlFilms.setItems(films);
        marshaller.marshal(xmlFilms,writer);
        String result = writer.toString();
        if(filteredFilms.isEmpty() != true) {
            mailServiceImpl.sendSimpleEmail("programmtest97@gmail.com", "test", result);
        }
        return filmsMapper.toDtos(filteredFilms);
    }
}
