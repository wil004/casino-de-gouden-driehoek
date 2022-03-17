package novi.blackjack;

import java.util.Scanner;

public class LowDeckBlackJack extends BlackjackGame {


    public LowDeckBlackJack(Scanner inputScanner) {
        super(inputScanner);
        setDeck(new LowDeck());
    }
}
