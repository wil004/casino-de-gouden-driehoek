package novi.blackjack;

import java.util.List;

public class Hand {
    private int value;
    private String type;


    private final List<Card> cardsInHand;

    public Hand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;

    }

    public int getValue() {
        this.value = 0;
        for (int i = 0; i < cardsInHand.size(); i++) {
            this.value = cardsInHand.get(i).getCardValue() + this.value;
        }
        return this.value;
    }

    public String getType() {
        for (int i = 0; i < cardsInHand.size(); i++) {
            if (i != 0) {
                this.type = this.type + cardsInHand.get(i).getCardType() + " | ";
            } else {
                this.type = " | " + cardsInHand.get(i).getCardType() + " | ";
            }
        }
        return type;
    }


    public void addCard(Card card) {
        cardsInHand.add(card);
    }
}
