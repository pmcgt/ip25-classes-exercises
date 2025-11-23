import exercises.Hangman;

void main() {
    Hangman hangman = new Hangman();

    hangman.printWelcome();
    while (!hangman.isGuessWordFound()) {
        hangman.printGameboard();
        String userInput = IO.readln();
        if(!userInput.isEmpty()) {
            hangman.handleGuessLetter(userInput.charAt(0));
        }
    }
}