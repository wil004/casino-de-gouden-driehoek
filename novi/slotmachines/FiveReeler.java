package novi.slotmachines;

public class FiveReeler extends SlotMachine{
    public FiveReeler() {
        super.setNumberOfReels(5);
    }

    @Override
    public int getRollPrice() {
        return 5;
    }

    @Override
    public int calculatePayout() {
        return 200;
    }

}
