package novi.blackjack;

        import java.util.Scanner;

public class SimpleBlackJack extends BlackjackGame {


    public SimpleBlackJack(Scanner inputScanner) {
        super(inputScanner);
        setDeck(new LowDeck());
    }
}