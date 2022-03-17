package novi.slotmachines;

import java.util.Random;

public class Reel {
    Random random;
    public int icon;
    public Symbol symbol;

    public Reel() {
        random = new Random();
        roll();
    }

    public void roll() {
        icon = random.nextInt(3);
        if (icon == 0) {
            symbol = new Symbol('x');
        } else if (icon == 1) {
            symbol = new Symbol('7');
        } else {
            symbol = new Symbol('3');
        }
    }


    public Symbol renderedSymbol() {
        return symbol;
    }

}
