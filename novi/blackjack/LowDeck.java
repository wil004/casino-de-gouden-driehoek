package novi.blackjack;

public class LowDeck extends Deck{
    public LowDeck() {
        addDeck();
        addDeck();
        addDeck();
    }
    public void addDeck() {
        getCardValues().add(new CardValue("twee", 2));
        getCardValues().add(new CardValue("drie", 3));
        getCardValues().add(new CardValue("vier", 4));
        getCardValues().add(new CardValue("vijf", 5));
        getCardValues().add(new CardValue("zes", 6));
    }
}
