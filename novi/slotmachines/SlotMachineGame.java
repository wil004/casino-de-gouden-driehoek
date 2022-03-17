package novi.slotmachines;
import java.util.Scanner;

public class SlotMachineGame {
    private Scanner inputScanner;
    private boolean gameIsRunning;
    private int coins;
    private SlotMachine slotMachine;

    public SlotMachineGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        this.coins = 100;
    }

    public void playGame() {
        System.out.println("Welcome to the game you have " + coins + " coins!");
        System.out.println("Which machine do u want to play at?");
        System.out.println("Press: 0 for penny machine, Press: 1 for High Roller machine, Press: 2 for 5-reeler.");
        var input = inputScanner.nextInt();
        SlotMachine pennyMachine = new Penny();
        SlotMachine highRoller = new HighRoller();
        SlotMachine fiveReeler = new FiveReeler();
        if (input == 0) {
            slotMachine = pennyMachine;
        } else if (input == 1) {
            slotMachine = highRoller;
        } else if (input == 2) {
            slotMachine = fiveReeler;
        }
        gameIsRunning = true;
        while (gameIsRunning) {
            System.out.println("coin-balance: " + coins);
            if (coins <= slotMachine.getRollPrice()) {
                System.out.println("You don't have enough coins to play this game");
                gameIsRunning = false;
            }
            System.out.println("Press 0 to pull the lever.");
            var pullLever = inputScanner.nextInt();
            if (pullLever == 0) {
                    slotMachine.spin();
                    this.coins = coins - slotMachine.getRollPrice();
                    System.out.println("You've paid " + slotMachine.getRollPrice() + " your new balance = " + coins);
                    slotMachine.renderedTokens();
                    slotMachine.wonOrLoseGame();
                    if (slotMachine.getWonGame()) {
                        coins = slotMachine.calculatePayout() + coins;
                        System.out.println(slotMachine.calculatePayout() + " coins has been added to your wallet total amount: " + coins);
                        slotMachine.setWonGameToFalse();
                    }
                } else {
                System.out.println("Wrong button please try again!");
            }
            System.out.println("Press 0 to play one more round, press 1 to stop the game!");
            var continueGame = inputScanner.nextInt();
             if (continueGame == 1) {
                 gameIsRunning = false;
             }
        }
    }
}
