package novi.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
   private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void setCards() {
        List<CardType> cardTypes = new ArrayList<>();
        cardTypes.add(new CardType("ruite", "rood"));
        cardTypes.add(new CardType("harte", "rood"));
        cardTypes.add(new CardType("klaver", "zwart"));
        cardTypes.add(new CardType("schoppe", "zwart"));

        List<CardValue> cardValues = new ArrayList<>();
        cardValues.add(new CardValue("twee", 2));
        cardValues.add(new CardValue("drie", 3));
        cardValues.add(new CardValue("vier", 4));
        cardValues.add(new CardValue("vijf", 5));
        cardValues.add(new CardValue("zes", 6));
        cardValues.add(new CardValue("zeven", 7));
        cardValues.add(new CardValue("acht", 8));
        cardValues.add(new CardValue("negen", 9));
        cardValues.add(new CardValue("tien", 10));
        cardValues.add(new CardValue("boer", 10));
        cardValues.add(new CardValue("koningin", 10));
        cardValues.add(new CardValue("koning", 10));


        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < cardTypes.size(); i++) {
            for(int j = 0; j < cardValues.size(); j++) {
                cards.add(new Card(cardTypes.get(i), cardValues.get(j)));
            }
        }
        this.cards = cards;
    }

    public void shuffleCards() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int randomNumber = random.nextInt(cards.size());
            Card switchingCard = cards.get(i);
            cards.set(i, cards.get(randomNumber));
            cards.set(randomNumber, switchingCard);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

}
