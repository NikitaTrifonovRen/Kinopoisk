package com.example.kinopoisk.model;

public class FilmSearch {
    private Integer countries;
    private Integer genres;
    private String order;
    private String type;
    private Double ratingFrom;
    private Double ratingTo;
    private Integer yearFrom;
    private Integer yearTo;
    private String imdbId;
    private String keyword;
    private Integer page;

    public Integer getCountries() {
        return countries;
    }

    public void setCountries(Integer countries) {
        this.countries = countries;
    }

    public Integer getGenres() {
        return genres;
    }

    public void setGenres(Integer genres) {
        this.genres = genres;
    }

    public Double getRatingFrom() {
        return ratingFrom;
    }

    public void setRatingFrom(Double ratingFrom) {
        this.ratingFrom = ratingFrom;
    }

    public Double getRatingTo() {
        return ratingTo;
    }

    public void setRatingTo(Double ratingTo) {
        this.ratingTo = ratingTo;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
