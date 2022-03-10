package novi.blackjack;

public class CardType {
    private String name;
    private String color;

    public CardType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
