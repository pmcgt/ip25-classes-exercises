package exercises;

import java.util.Arrays;

public class Hangman {
    private String[] GUESS_WORDS = {
            "apple",
            "chair",
            "house",
            "music",
            "river",
            "smile",
            "galaxy",
            "thunder",
            "fiction",
            "lantern",
            "mystery",
            "journal",
            "labyrinth",
            "chandelier",
            "whirlwind",
            "masquerade",
            "kaleidoscope",
            "phosphorescent"
    };
    private String guessWord;
    private char[] gameboard;

    public Hangman() {
        int index = (int) (Math.random() * GUESS_WORDS.length);
        this.guessWord = GUESS_WORDS[index];
        this.gameboard = generateGameboard(this.guessWord);
    }

    private char[] generateGameboard(String guessWord) {
        char[] gameboard = new char[guessWord.length()];
        Arrays.fill(gameboard, '_');
        return gameboard;
    }

    private void updateBoard(char letter) {
        for (int i = 0; i < this.guessWord.length(); i++) {
            if(guessWord.charAt(i) == letter) {
               this.gameboard[i] = letter;
            }
        }
    }

    public void handleGuessLetter(char guessLetter){
        updateBoard(guessLetter);
        if(isGuessWordFound()) {
            printGameboard();
            IO.println("Congratulations! See ya next time!");
        }
    }

    public boolean isGuessWordFound() {
        int count = 0;
        for (int i = 0; i < this.gameboard.length; i++) {
            if (this.gameboard[i] == '_' ) {
                count++;
            }
        }
        return count == 0;
    }

    public void printGameboard() {
        for (int i = 0; i < this.gameboard.length; i++) {
            IO.print(gameboard[i]);
        }
        IO.println();
    }

    public void printWelcome() {
        IO.println("~Welcome to Hangman~");
        IO.println("With each new game a random word is selected");
        IO.println("Type the letter you think it's in the guess word");
        IO.println("Have fun!\n");
    }

}
