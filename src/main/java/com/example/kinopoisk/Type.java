package com.example.kinopoisk;

public enum Type {
    FILM("&type=FILM"),
    ALL("&type=ALL"),
    TVSHOW("&type=TV_SHOW"),
    TVSIRIES("&type=TV_SERIES"),
    MINISIRIES("&type=MINI_SERIES");
    private String title;
    Type(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
