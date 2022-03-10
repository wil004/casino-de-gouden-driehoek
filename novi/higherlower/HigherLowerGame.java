package novi.higherlower;

import java.util.Scanner;
import java.util.Random;

public class HigherLowerGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        // Here you should generate the number to guess
        Random random = new Random();
        int winningNumber = random.nextInt(101);
        gameIsRunning = true;

        int playedRounds = 0;


        System.out.println("Choose a number between 0 and 100");
        while (gameIsRunning) {
            System.out.println("Make a guess");

            var input = inputScanner.nextLine();
            System.out.printf("You typed: %s\n", input);
            playedRounds = playedRounds + 1;
            System.out.println("Rounds: " + playedRounds);

            if (Integer.parseInt(input) > winningNumber) {
                System.out.println("That number is too high!");
            } else if (Integer.parseInt(input) == winningNumber) {
                System.out.println("Congratulations you have won the game the winning number is " + winningNumber);
                System.out.println("It took you a total of " + playedRounds + " rounds to win!");
                gameIsRunning = false;
                playedRounds = 0;
            } else {
                System.out.println("That number is too low!");
            }

            // Check if the guess is correct, if so end the game
        }
    }
}
