package novi.blackjack;

import java.util.Objects;
import java.util.Scanner;

public class BlackjackGame {
    private Scanner inputScanner;
    private Deck deck;
    private final Player player;
    private final Player computer;
    private int numberOfCardsInField;

    public BlackjackGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        player = new Player("William", deck.getCards().get(0), deck.getCards().get(2));
        computer = new Player("Computer", deck.getCards().get(1), deck.getCards().get(3));
        System.out.println("Welkom bij blackjack");
        System.out.println("De computer heeft 2 kaarten 1 daarvan is| " + deck.getCards().get(1).getCardType() + "| punten: " + deck.getCards().get(1).getCardValue());
        this.numberOfCardsInField = 4;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
        deck.setCards();
        deck.shuffleCards();
    }

    public void playGame() {
        while (!player.getIsStaying() && !player.getIsBust()) {
            System.out.println(player.getName() + " heeft de kaarten " + player.getHandTypes() + " met een totale waarde van: " +
                    player.getHandValue() );
            if (player.getHandValue() > 21) {
                System.out.println("U heeft verloren uw totale waarde ligt boven de 21");
                player.setIsBust();
                computer.setIsStaying();
                break;
            }
            System.out.println(player.getName() + " wat is uw keuze typ 'hit' of 'stay'!");
            String input = inputScanner.nextLine();
            if (Objects.equals(input, "hit")) {
                player.addCards(deck.getCards().get(numberOfCardsInField));
                System.out.println(player.getName() + " u heeft de " + deck.getCards().get(numberOfCardsInField).getCardType() + " getrokken!");
                numberOfCardsInField = numberOfCardsInField + 1;
            } else if (input.equals("stay")) {
                player.setIsStaying();
                System.out.println("De computer is aan de beurt ");
            }
        }


        while (!computer.getIsStaying() && !computer.getIsBust()) {
            System.out.println(computer.getName() + " heeft de kaarten " + computer.getHandTypes() + " met een totale waarde van: " +
                    computer.getHandValue() );
            if (computer.getHandValue() > 21) {
                System.out.println(player.getName() + " heeft gewonnen! " + computer.getName() + " is busted!");
                computer.setIsBust();
            }

            if (computer.getHandValue() < 17 || computer.getHandValue() < player.getHandValue()) {
                computer.addCards(deck.getCards().get(numberOfCardsInField));
                System.out.println(computer.getName() + " heeft de " + deck.getCards().get(numberOfCardsInField).getCardType() + " getrokken!");
                numberOfCardsInField = numberOfCardsInField + 1;
            } else if (computer.getHandValue() >= 17) {
                computer.setIsStaying();
            }
        }

        if (!computer.getIsBust()) {
            if (player.getHandValue() > computer.getHandValue()) {
                System.out.println(player.getName() + " heeft gewonnen met de hand " + player.getHandTypes() + " met een totale waarde" +
                        " van: " + player.getHandValue());
            } else if (computer.getHandValue() > player.getHandValue()) {
                System.out.println(computer.getName() + " heeft gewonnen met de hand " + computer.getHandTypes() + " met een totale waarde" +
                        " van: " + computer.getHandValue());
            } else {
                System.out.println("Gelijkspel beide spelers hebben dezelfde punten namelijk: " + player.getHandValue());
            }
        }
    }

}

