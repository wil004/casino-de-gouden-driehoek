package novi.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private boolean isStaying;
    private boolean isBust;
    private final List<Card> cardsInHand;
    private final Hand handValue;


    public Player(String name, Card firstCard, Card secondCard) {
        this.name = name;
        this.cardsInHand = new ArrayList<>();
        this.isStaying = false;
        this.isBust = false;
        cardsInHand.add(firstCard);
        cardsInHand.add(secondCard);
        this.handValue = new Hand(cardsInHand);
    }

    public void setIsStaying() {
        this.isStaying = true;
    }

    public void setIsBust() {
        this.isBust = true;
    }

    public boolean getIsStaying() {
        return this.isStaying;
    }

    public boolean getIsBust() {
        return this.isBust;
    }

    public void addCards(Card card) {
        handValue.addCard(card);
    }

    public String getName() {
        return this.name;
    }

    public int getHandValue() {
        return handValue.getValue();
    }

    public String getHandTypes() {
        return handValue.getType();
    }

}
