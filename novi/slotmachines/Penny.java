package novi.slotmachines;

public class Penny extends SlotMachine{
    public Penny() {
        super.setNumberOfReels(3);
    }

    @Override
    public int getRollPrice() {
        return 1;
    }

    @Override
    public int calculatePayout() {
        return 10;
    }

}