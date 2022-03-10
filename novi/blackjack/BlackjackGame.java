package novi.blackjack;

import java.util.Objects;
import java.util.Scanner;

public class BlackjackGame {
    private Scanner inputScanner;

    public BlackjackGame(Scanner inputScanner) {
       this.inputScanner = inputScanner;
    }

    public void playGame() {
        Deck lijst = new Deck();
        lijst.setCards();
        lijst.shuffleCards();

        Player william = new Player("William", lijst.getCards().get(0), lijst.getCards().get(2));
        Player computer = new Player("Computer", lijst.getCards().get(1), lijst.getCards().get(3));

        System.out.println("Welkom bij blackjack");
        System.out.println("De computer heeft 2 kaarten 1 daarvan is| " + lijst.getCards().get(1).getCardType() + "| punten: " + lijst.getCards().get(1).getCardValue());


        int numberOfCardsInField = 4;

        while (!william.getIsStaying() && !william.getIsBust()) {
            System.out.println(william.getName() + " heeft de kaarten " + william.getHandTypes() + " met een totale waarde van: " +
                    william.getHandValue() );
            if (william.getHandValue() > 21) {
                System.out.println("U heeft verloren uw totale waarde ligt boven de 21");
                william.setIsBust();
                computer.setIsStaying();
                break;
            }
            System.out.println(william.getName() + " wat is uw keuze typ 'hit' of 'stay'!");
            String input = inputScanner.nextLine();
            if (Objects.equals(input, "hit")) {
                william.addCards(lijst.getCards().get(numberOfCardsInField));
                System.out.println(william.getName() + " u heeft de " + lijst.getCards().get(numberOfCardsInField).getCardType() + " getrokken!");
                numberOfCardsInField = numberOfCardsInField + 1;
            } else if (input.equals("stay")) {
                william.setIsStaying();
                System.out.println("De computer is aan de beurt ");
            }
        }


        while (!computer.getIsStaying() && !computer.getIsBust()) {
            System.out.println(computer.getName() + " heeft de kaarten " + computer.getHandTypes() + " met een totale waarde van: " +
                    computer.getHandValue() );
            if (computer.getHandValue() > 21) {
                System.out.println(william.getName() + " heeft gewonnen! " + computer.getName() + " is busted!");
                computer.setIsBust();
            }

            if (computer.getHandValue() < 17 || computer.getHandValue() < william.getHandValue()) {
                computer.addCards(lijst.getCards().get(numberOfCardsInField));
                System.out.println(computer.getName() + " heeft de " + lijst.getCards().get(numberOfCardsInField).getCardType() + " getrokken!");
                numberOfCardsInField = numberOfCardsInField + 1;
            } else if (computer.getHandValue() >= 17) {
                computer.setIsStaying();
            }
        }

        if (!computer.getIsBust()) {
            if (william.getHandValue() > computer.getHandValue()) {
                System.out.println(william.getName() + " heeft gewonnen met de hand " + william.getHandTypes() + " met een totale waarde" +
                        " van: " + william.getHandValue());
            } else if (computer.getHandValue() > william.getHandValue()) {
                System.out.println(computer.getName() + " heeft gewonnen met de hand " + computer.getHandTypes() + " met een totale waarde" +
                        " van: " + computer.getHandValue());
            } else {
                System.out.println("Gelijkspel beide spelers hebben dezelfde punten namelijk: " + william.getHandValue());
            }
        }
    }

}

