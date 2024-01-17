package com.example.kinopoisk;

public enum Order {
    RATING ("?order=RATING"),
    NUMVOTE ("?order=NUM_VOTE"),
    YEAR("?order=YEAR");
    private String title;
    Order(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
