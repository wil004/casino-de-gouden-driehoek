package novi.slotmachines;

import novi.blackjack.Deck;

public abstract class SlotMachine {
    private ReelDeck deck;
    private boolean tokensEqual;
    private boolean wonGame;

    public SlotMachine() {
        this.tokensEqual = true;
        this.wonGame = false;
    }

    public void setNumberOfReels(int numberOfReels) {
        deck = new ReelDeck(numberOfReels);
    }

    public void spin() {
        deck.roll();
    }

    public void winningConditions() {
        for (int i = 0; i < deck.render().size(); i++) {
            if (deck.render().get(0).renderedSymbol().getIcon() != (deck.render().get(i).renderedSymbol().getIcon())) {
                this.tokensEqual = false;
            }
        }
        if (tokensEqual) {
            this.wonGame = true;
        }
    }

    public boolean getWonGame() {
        return wonGame;
    }

    public void setWonGameToFalse() {
        wonGame = false;
    }

    public void wonOrLoseGame() {
        winningConditions();
        if (wonGame) {
            System.out.println("Congratiolations all tokens are the same u won the game");
        } else {
            System.out.println("You lost please try again");
            this.tokensEqual = true;
        }
    }

    public void renderedTokens() {
        for (int i = 0; i < deck.render().size(); i++) {
            System.out.println("|" + deck.render().get(i).renderedSymbol().getIcon() + "|");
        }
    }

    public abstract int getRollPrice();

    public abstract int calculatePayout();


}
