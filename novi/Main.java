package novi;

import novi.hangman.HangmanGame;
import novi.hangman.ImageFactory;
import novi.slotmachines.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        HangmanGame hoi = new HangmanGame(userInput);
        hoi.playGame();
    }
}
