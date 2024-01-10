package com.example.kinopoisk.model;

import jakarta.persistence.*;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filmId")
    Long filmId;
    @Column(name = "filmName")
    String filmName;
    @Column(name = "year")
    int year;
    @Column(name = "rating")
    double rating;
    @Column(name = "description")
    String description;
    public Film(){
    }
    public Film(String filmName, int year, double rating, String description) {
        this.filmName = filmName;
        this.year = year;
        this.rating = rating;
        this.description = description;
    }

    public String getFilmName() {
        return filmName;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
