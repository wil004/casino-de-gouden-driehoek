package novi.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Deck {
   private List<Card> cards;
   private List<CardType> cardTypes;
   private List<CardValue> cardValues;

    public Deck() {
        cards = new ArrayList<>();
        cardTypes = new ArrayList<>();
        cardValues = new ArrayList<>();
        cardTypes.add(new CardType("ruite", "rood"));
        cardTypes.add(new CardType("harte", "rood"));
        cardTypes.add(new CardType("klaver", "zwart"));
        cardTypes.add(new CardType("schoppe", "zwart"));
    }

    public abstract void addDeck();

    public List<CardValue> getCardValues() {
        return cardValues;
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

    public void setCards() {
        for(int i = 0; i < cardTypes.size(); i++) {
            for(int j = 0; j < cardValues.size(); j++) {
                getCards().add(new Card(cardTypes.get(i), cardValues.get(j)));
            }
        }
    }

}
