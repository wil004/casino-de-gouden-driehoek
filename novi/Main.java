package novi;

import novi.slotmachines.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
       SlotMachineGame play = new SlotMachineGame(userInput);
       play.playGame();
    }
}
