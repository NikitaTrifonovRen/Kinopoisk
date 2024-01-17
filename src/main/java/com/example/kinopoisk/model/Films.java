package com.example.kinopoisk.model;

import java.util.List;

public class Films {
    private List<FilmMaping> items;
    public Films(){
    }
    public List<FilmMaping> getItems() {
        return items;
    }

    public void setItems(List<FilmMaping> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Films{" +
                "items=" + items.toString() +
                '}';
    }
}
