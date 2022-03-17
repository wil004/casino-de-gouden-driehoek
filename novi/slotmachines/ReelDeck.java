package novi.slotmachines;

import java.util.ArrayList;
import java.util.List;

public class ReelDeck {
    List<Reel> reels;
    private int numberOfReels;

    public ReelDeck(int numberOfReels) {
        reels = new ArrayList<>();
        this.numberOfReels = numberOfReels;
        for (int i = 0; i < numberOfReels; i++) {
            reels.add(new Reel());
        }
    }

    public void roll() {
        for (int i = 0; i < numberOfReels; i++) {
            reels.set(i, new Reel());
        }
    }

    public List<Reel> render() {
        return reels;
    }

}
