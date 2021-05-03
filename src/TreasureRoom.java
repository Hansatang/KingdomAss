import Valuables.Valuable;

import java.util.ArrayList;

public class TreasureRoom implements TreasureRoomDoor {
    private ArrayList<Valuable> valuables;

    public TreasureRoom() {
        valuables = new ArrayList<>();
    }

    @Override
    public void addValuables(ArrayList<Valuable> listOfValuables) {

        valuables.addAll(listOfValuables);
    }

    @Override
    public Valuable retrieveValuables() {
       return valuables.remove(0);
    }

    @Override
    public ArrayList<Valuable> lookAtValuables() {
        return valuables;
    }

    @Override
    public String toString() {
        return "TreasureRoom{" +
                "valuables=" + valuables +
                '}';
    }
}
