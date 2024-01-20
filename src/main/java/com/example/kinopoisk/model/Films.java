package com.example.kinopoisk.model;

import java.util.List;

public class Films {
    private List<Film> items;
    public Films(){
    }
    public List<Film> getItems() {
        return items;
    }


    public void setItems(List<Film> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Films{" +
                "items=" + items.toString() +
                '}';
    }
}
