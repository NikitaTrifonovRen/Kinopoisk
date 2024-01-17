package com.example.kinopoisk.model;

import java.io.Serializable;

public class FilmMaping {

    private String imdbId;
    private String nameRu;
    private String nameEn;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public FilmMaping() {

    }
}
