package com.company;

public class MovieList {
    private int randomNumber;
    private String name;

    static String[] list = {"Titanic", "Star Wars", "A Dog’s Purpose", "The Space Between Us",
            "Fist Fight", "The Boss Baby", "Baywatch", "The Founders", "Transformers"};

    public String getRandomMovie() {
        randomNumber = (int) (Math.random()*list.length);
        name = list[randomNumber];
        return name;
    }
}
