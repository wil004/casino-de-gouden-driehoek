package novi.slotmachines;

public class HighRoller extends SlotMachine{
    public HighRoller() {
        super.setNumberOfReels(3);
    }

    @Override
    public int getRollPrice() {
        return 10;
    }

    @Override
    public int calculatePayout() {
        return 100;
    }

}