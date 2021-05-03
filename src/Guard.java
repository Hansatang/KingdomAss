import Valuables.Valuable;

import java.util.ArrayList;

public class Guard implements TreasureRoomDoor
{
  private ArrayList<Valuable> valuables;
  private TreasureRoomDoor treasureRoomDoor;

  public Guard() {
    valuables = new ArrayList<>();
  }

  @Override
  public void addValuables(ArrayList<Valuable> listOfValuables) {
    treasureRoomDoor.addValuables(listOfValuables);
  }

  @Override
  public Valuable retrieveValuables() {
    return null;
  }

  @Override
  public ArrayList<Valuable> lookAtValuables() {
    return null;
  }

}
