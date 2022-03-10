package novi.blackjack;

public class Card {
    CardType cardType;
    CardValue cardValue;

    public Card(CardType cardType, CardValue cardValue) {
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    public String getCardType() {
        return cardType.getName() + " " + cardType.getColor() + " " + cardValue.getName();
    }

    public int getCardValue() {
        return cardValue.getValue();
    }

}
