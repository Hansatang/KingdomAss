import Valuables.Valuable;

import java.util.ArrayList;

public class Guard implements TreasureRoomDoor
{
  private ArrayList<Valuable> valuables;

  public Guard() {
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
