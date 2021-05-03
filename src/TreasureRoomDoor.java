import Valuables.Valuable;

import java.util.ArrayList;

public interface TreasureRoomDoor {

    void addValuables(ArrayList<Valuable> valuables);
    void retrieveValuables(ArrayList<Valuable> valuables);
    ArrayList<Valuable> lookAtValuables();



}
