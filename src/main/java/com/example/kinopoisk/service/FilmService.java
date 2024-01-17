package com.example.kinopoisk.service;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.example.kinopoisk.Order;
import com.example.kinopoisk.Type;
import com.example.kinopoisk.model.Film;
import com.example.kinopoisk.model.FilmSearch;
import com.example.kinopoisk.model.Films;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FilmService {
    private RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();


    private static final String kpApi =
            "https://kinopoiskapiunofficial.tech/api/v2.2/films";
    public Films getAllFilms(){
        String url = kpApi + Order.RATING.getTitle() + Type.ALL.getTitle();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-API-KEY","06c25e47-c7a4-439f-beed-ea885b782d39");
//        httpHeaders.set("accept","application/json");
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//        messageConverters.add(converter);
//        restTemplate.setMessageConverters(messageConverters);

        //return restTemplate.getForObject(url, Films.class);
        //return restTemplate.getForEntity(url, Films.class).getBody();
        return restTemplate.exchange(url, HttpMethod.GET, entity,Films.class).getBody();

    }
//    public Films getAllFilms(Order order, Type type){
//        String url = kpApi + order + type;
//        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        httpHeaders.set("X-API-KEY","06c25e47-c7a4-439f-beed-ea885b782d39");
//        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);
//        return restTemplate.exchange(url, HttpMethod.GET, entity,Films.class).getBody();
////        return restTemplate.getForEntity(url, Films.class).getBody();
//    }
//    public Films films (Order order, Type type, FilmSearch params){
//        String url = kpApi + order + type;
//        if (params.getRatingFrom() != null) url += "&ratingFrom=" + params.getRatingFrom();
//        if (params.getRatingTo() != null) url += "&ratingTo=" + params.getRatingTo();
//        if (params.getYearFrom() != null) url += "&yearFrom=" + params.getYearFrom();
//        if (params.getYearTo() != null) url += "&yearTo=" + params.getYearTo();
//        if (Strings.isNotBlank(params.getImdbId())) url += "&imdbId=" + params.getImdbId();
//        if (Strings.isNotBlank(params.getKeyword())) url += "&keyword=" + params.getKeyword();
//        if (params.getPage() != null && params.getPage() >= 1 && params.getPage() <= 20)
//            url += "&page=" + params.getPage();
//        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        httpHeaders.set("X-API-KEY","06c25e47-c7a4-439f-beed-ea885b782d39");
//        HttpEntity<String> entity = new HttpEntity<>("body", httpHeaders);
//        return restTemplate.exchange(url, HttpMethod.GET, entity,Films.class).getBody();
//    }



}
