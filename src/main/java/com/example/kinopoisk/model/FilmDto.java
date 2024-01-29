package com.example.kinopoisk.model;

public class FilmDto {

    private Long kinopoiskId;

    private String nameRu;

    private int year;

    private double ratingKinopoisk;

    private String description;

    public FilmDto() {
    }

    public Long getKinopoiskId() {
        return kinopoiskId;
    }

    public void setKinopoiskId(Long kinopoiskId) {
        this.kinopoiskId = kinopoiskId;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRatingKinopoisk() {
        return ratingKinopoisk;
    }

    public void setRatingKinopoisk(double ratingKinopoisk) {
        this.ratingKinopoisk = ratingKinopoisk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
