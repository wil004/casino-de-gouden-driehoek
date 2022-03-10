package novi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import novi.blackjack.Card;
import novi.blackjack.Deck;
import novi.higherlower.HigherLowerGame;
import novi.blackjack.BlackjackGame;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        BlackjackGame game = new BlackjackGame(inputScanner);

        game.playGame();
    }
}
