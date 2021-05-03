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
    public void retrieveValuables(ArrayList<Valuable> listOfValuables) {
        valuables.removeAll(listOfValuables);
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
