package novi.blackjack;

public class SimpleDeck extends Deck{
    public SimpleDeck() {
            addDeck();
    }

    public void addDeck() {
        getCardValues().add(new CardValue("twee", 2));
        getCardValues().add(new CardValue("drie", 3));
        getCardValues().add(new CardValue("vier", 4));
        getCardValues().add(new CardValue("vijf", 5));
        getCardValues().add(new CardValue("zes", 6));
        getCardValues().add(new CardValue("zeven", 7));
        getCardValues().add(new CardValue("acht", 8));
        getCardValues().add(new CardValue("negen", 9));
        getCardValues().add(new CardValue("tien", 10));
        getCardValues().add(new CardValue("boer", 10));
        getCardValues().add(new CardValue("koningin", 10));
        getCardValues().add(new CardValue("koning", 10));
    }
}
