package novi.hangman;

import java.util.*;

public class HangmanGame {
    private boolean isWordGuessed;
    private Scanner inputScanner;
    private int wrongGuesses;
    private int totalGuessesLeft;


    public HangmanGame(Scanner inputScanner) {
        this.isWordGuessed = false;
        this.inputScanner = inputScanner;
        this.totalGuessesLeft = 8;
        this.wrongGuesses = 0;
    }

    protected void printImage() {
        for(int i = 0; i < wrongGuesses; i++) {
            if (i < 2) {
                System.out.println(ImageFactory.getImage(i));
            } else if (i < 3) {
                System.out.print(ImageFactory.getImage(i));
            } else if (i == 4) {
                System.out.println(ImageFactory.getImage(i));
            } else if (i == 5) {
                System.out.println(ImageFactory.getImage(i));
            }
            else {
                System.out.print(ImageFactory.getImage(i));
            }
        }
    }

    public void playGame() {
        DuplicateLetterException wrongLetters = new DuplicateLetterException();
        int guessedLetters = 0;
        String word = ImageFactory.createWord();
        String encryptedWord = "";
        char[] charsWord = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            encryptedWord = encryptedWord + "*";
        }

        char[] charsEncryptedWord = encryptedWord.toCharArray();

        System.out.println("Guess the word.");
        while (!isWordGuessed && totalGuessesLeft > 0) {
            System.out.println("");
            System.out.println(encryptedWord);
            guessedLetters = 0;
            char userInput = inputScanner.next().charAt(0);
            if (!encryptedWord.contains(String.valueOf(userInput))) {
                for (int i = 0; i < charsEncryptedWord.length; i++) {
                    if (userInput == charsWord[i]) {
                        charsEncryptedWord[i] = userInput;
                        encryptedWord = Arrays.toString(charsEncryptedWord);
                        guessedLetters = guessedLetters + 1;
                    }
                }
                if (Arrays.toString(charsWord).equals(Arrays.toString(charsEncryptedWord))) {
                    System.out.println(encryptedWord);
                    System.out.println("You won the game the word is " + word);
                    this.isWordGuessed = true;
                    wrongLetters.getWrongLetters().clear();
                } else if (guessedLetters > 0) {
                    System.out.println("");
                    System.out.println("You guessed a right letter: " + userInput);
                    printImage();

                } else {
                    wrongLetters.setWrongLetters(userInput);
                    if (wrongLetters.getLetterAlreadyGuessed()) {
                        System.out.println("This letter has already been guessed please fill in a number that hasn't been guessed yet");
                    } else {
                        totalGuessesLeft = totalGuessesLeft - 1;
                        wrongGuesses = wrongGuesses + 1;
                        printImage();
                        System.out.println("");
                        System.out.println("You have " + totalGuessesLeft + " tries left");
                        if (totalGuessesLeft == 0) {
                            System.out.println("You lost the game the word was " + word);
                            wrongLetters.getWrongLetters().clear();
                        }
                    }
                }
            } else {
                System.out.println("You already guessed this number please guess again");
            }
        }
    }
}
