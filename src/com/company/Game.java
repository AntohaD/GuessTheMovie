package com.company;

import java.util.Scanner;

public class Game {

    private String movieGuess;
    private int countLost;
    private String rightLetters;
    private String wrongLetters;
    private boolean hasWon;

    public Game() {
        MovieList movieList = new MovieList();
        movieGuess = movieList.getRandomMovie();
        countLost = 0;
        rightLetters = "";
        wrongLetters = "";
        hasWon = false;
    }

    public String getMovieTitle() {
        return movieGuess;
    }

    public String getHiddenTitle () {
        if (rightLetters.equals("")) {
            return movieGuess.replaceAll("[a-zA-Z]", "_");
        } else {
            return movieGuess.replaceAll("[a-zA-Z&&[^" + rightLetters +"]]", "_");
        }
    }

    public String getWrongLetters() {
        return wrongLetters;
    }

    public boolean wonGame() {
        return hasWon;
    }

    public boolean endGame() {
        if (countLost >= 10) {
            return true;
        }
        if (!getHiddenTitle().contains("_")) {
            hasWon = true;
            return true;
        }
        return false;
    }

    private String inputLetter () {
        System.out.println("Guess a letter: ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if (!letter.matches("[a-z]")) {
            System.out.println("That is not a letter.");
            return inputLetter();
        } else if (wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("You already guessed that letter.");
            return inputLetter();
        } else {
            return letter;
        }
    }

    public void guessLetter() {
        String guessLetter = inputLetter();

        if (movieGuess.toLowerCase().contains(guessLetter)) {
            rightLetters += guessLetter + guessLetter.toUpperCase();
        } else {
            countLost++;
            wrongLetters += " " + guessLetter;
        }
    }
}
