import Valuables.Valuable;

import java.util.ArrayList;

public class King implements Runnable
{
  private int limit = (int) (Math.random() * 100 + 50);
  private TreasureRoomDoor treasureRoomDoor;
  private ArrayList<Valuable> list;
  private int worth = 0;

  public King(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override public void run()
  {
    while (true)
    {
      spendTime(1000);
      System.out.println("Im asking for write");
      treasureRoomDoor.acquireWrite();
      for (int i = 0; i < treasureRoomDoor.getSize; i++)
      {
        list.add(treasureRoomDoor.retrieveValuables());
        worth += list.get(list.size() - 1).getWorth();
        if (worth > limit)
        {
          break;
        }
      }
      if (worth < limit)
      {
        treasureRoomDoor.addValuables(list);
      }

      treasureRoomDoor.releaseWrite();
      System.out.println("Im releasing the write");
    }
  }

  public void spendTime(int sleepTime)
  {
    try
    {
      Thread.sleep(sleepTime);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

}
}
