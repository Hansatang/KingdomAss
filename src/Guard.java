import Valuables.Valuable;

import java.util.ArrayList;

public class Guard implements TreasureRoomDoor
{
  private TreasureRoomDoor treasureRoomDoor;

  public Guard(TreasureRoomDoor treasureRoomDoor) {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override
  public void addValuables(ArrayList<Valuable> listOfValuables) {
    treasureRoomDoor.addValuables(listOfValuables);
  }

  @Override
  public Valuable retrieveValuables() {
    return treasureRoomDoor.retrieveValuables();
  }

  @Override
  public ArrayList<Valuable> lookAtValuables() {
    return treasureRoomDoor.lookAtValuables();
  }

  @Override
  public void aquireRead() {
    treasureRoomDoor.aquireRead();
  }

  @Override
  public void aquireWrite() {
    treasureRoomDoor.aquireWrite();
  }

  @Override
  public void releaseRead() {
    treasureRoomDoor.releaseRead();
  }

  @Override
  public void releaseWrite() {
    treasureRoomDoor.releaseWrite();
  }

}
