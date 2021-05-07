import Valuables.Valuable;

import java.util.ArrayList;

public interface TreasureRoomDoor
{

  /** Method for adding ArrayList of Valuables to existing ArrayList */
  void addValuables(ArrayList<Valuable> valuables);

  /** Method for removing first item from ArrayList of Valuables */
  Valuable retrieveValuables();

  /** Method for getting ArrayList of Valuables to existing ArrayList */
  ArrayList<Valuable> lookAtValuables();

  /** Method for getting the size of ArrayList of Valuables */
  int getSize();

  /** Method for acquiring Read access */
  void aquireRead();

  /** Method for acquiring Write access */
  void aquireWrite();

  /** Method for releasing Read access */
  void releaseRead();

  /** Method for releasing Write access */
  void releaseWrite();

}
