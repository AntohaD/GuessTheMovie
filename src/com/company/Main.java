package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("Guess the name of the movie: ");
        System.out.println("The movie title has " + game.getMovieTitle().length() + " characters (including spaces "
                + "and punctuation).");

        while(!game.endGame()){
            System.out.println("You are guessing:" + game.getHiddenTitle());
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:"
                    + game.getWrongLetters());
            game.guessLetter();
        }
        if(game.wonGame()){
            System.out.println("You win!");
            System.out.println("You have guessed " + game.getMovieTitle() + " correctly.");
        }
        else{
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:" +
                    game.getWrongLetters());
            System.out.println("You lost!");
            System.out.println("The movie title was " + game.getMovieTitle());
        }
    }
}
