import Valuables.Valuable;

import java.util.ArrayList;

public class Guard implements TreasureRoomDoor
{
  private TreasureRoomDoor treasureRoomDoor;

  public Guard(TreasureRoomDoor treasureRoomDoor) {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override
  public synchronized void addValuables(ArrayList<Valuable> listOfValuables) {
    treasureRoomDoor.addValuables(listOfValuables);
  }

  @Override
  public synchronized Valuable retrieveValuables() {
    return treasureRoomDoor.retrieveValuables();
  }

  @Override
  public synchronized ArrayList<Valuable> lookAtValuables() {
    return treasureRoomDoor.lookAtValuables();
  }

  @Override synchronized public int getSize()
  {
    return treasureRoomDoor.getSize();
  }

  @Override
  public synchronized void aquireRead() {
    treasureRoomDoor.aquireRead();
  }

  @Override
  public synchronized void aquireWrite() {
    treasureRoomDoor.aquireWrite();
  }

  @Override
  public synchronized void releaseRead() {
    treasureRoomDoor.releaseRead();
  }

  @Override
  public synchronized void releaseWrite() {
    treasureRoomDoor.releaseWrite();
  }

}
