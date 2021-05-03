import Valuables.Valuable;

import java.util.ArrayList;

public interface TreasureRoomDoor {

    void addValuables(ArrayList<Valuable> valuables);
    Valuable retrieveValuables();
    ArrayList<Valuable> lookAtValuables();

    void aquireRead();
    void aquireWrite();
    void releaseRead();
    void releaseWrite();


}
