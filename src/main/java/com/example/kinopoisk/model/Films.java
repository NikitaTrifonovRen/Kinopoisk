package com.example.kinopoisk.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;
@XmlType(name = "films")
@XmlRootElement
public class Films {
    private List<FilmDto> items;
    public Films(){
    }
    public List<FilmDto> getItems() {
        return items;
    }


    public void setItems(List<FilmDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Films{" +
                "items=" + items.toString() +
                '}';
    }
}
