package com.example.kinopoisk.service;

import com.example.kinopoisk.Order;
import com.example.kinopoisk.Type;
import com.example.kinopoisk.model.Film;
import com.example.kinopoisk.model.FilmSearch;
import com.example.kinopoisk.model.Films;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class FilmSearchService {
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





    public Films getFilms(String countries, String genres, String order, String type, String ratingFrom, String ratingTo,
                          String yearFrom, String yearTo, String imdbId, String keyword, String page){
        String url = kpApi + "?";
        if(Strings.isNotBlank(countries)) url += "&countries=" + countries;
        if(Strings.isNotBlank(genres)) url += "&genres=" + genres;
        if(Strings.isNotBlank(order)) url += "&order=" + order;
        if(Strings.isNotBlank(type)) url += "&type=" + type;
        if(Strings.isNotBlank(ratingFrom)) url += "&ratingFrom=" + ratingFrom;
        if(Strings.isNotBlank(ratingTo)) url += "&ratingTo=" + ratingTo;
        if(Strings.isNotBlank(yearFrom)) url += "&yearFrom=" + yearFrom;
        if(Strings.isNotBlank(yearTo)) url += "&yearTo=" + yearTo;
        if(Strings.isNotBlank(imdbId)) url += "&imdbId=" + imdbId;
        if(Strings.isNotBlank(keyword)) url += "&keyword=" + keyword;
        if(Strings.isNotBlank(page)) url += "&page=" + page;
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-API-KEY","06c25e47-c7a4-439f-beed-ea885b782d39");
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, entity,Films.class).getBody();


    }



}
