package com.example.kinopoisk.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(name = "film")
@XmlRootElement
@Entity
@Table(name = "films")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "filmId")
    private Long kinopoiskId;
    @Column(name = "filmName")
    private String nameRu;
    @Column(name = "year")
    private int year;
    @Column(name = "rating")
    private double ratingKinopoisk;
    @Column(name = "description")
    private String description;
    public FilmEntity(){
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
