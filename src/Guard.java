import Valuables.Valuable;

import java.util.ArrayList;

public class Guard implements TreasureRoomDoor
{
  private TreasureRoomDoor treasureRoomDoor;

  public Guard(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  /** Method for adding ArrayList of Valuables to existing ArrayList as Proxy */
  @Override public void addValuables(ArrayList<Valuable> listOfValuables)
  {
    treasureRoomDoor.addValuables(listOfValuables);
  }

  /** Method for removing first item from ArrayList of Valuables as Proxy */
  @Override public Valuable retrieveValuables()
  {
    return treasureRoomDoor.retrieveValuables();
  }

  /** Method for getting ArrayList of Valuables to existing ArrayList as Proxy */
  @Override public ArrayList<Valuable> lookAtValuables()
  {
    return treasureRoomDoor.lookAtValuables();
  }

  /** Method for getting the size of ArrayList of Valuables as Proxy */
  @Override public int getSize()
  {
    return treasureRoomDoor.getSize();
  }

  /** Method for acquiring Read access */
  @Override public void aquireRead()
  {
    treasureRoomDoor.aquireRead();
  }

  /** Method for acquiring Write access */
  @Override public void aquireWrite()
  {
    treasureRoomDoor.aquireWrite();
  }

  /** Method for releasing Read access */
  @Override public void releaseRead()
  {
    treasureRoomDoor.releaseRead();
  }

  /** Method for releasing Write access */
  @Override public void releaseWrite()
  {
    treasureRoomDoor.releaseWrite();
  }

}
