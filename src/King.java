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
    this.list = new ArrayList<>();
  }

  @Override public void run()
  {
    while (true)
    {
      spendTime(4000);
      System.out.println(
          "                                                                                        Im asking for write");
      treasureRoomDoor.aquireWrite();
      int currentAmount = treasureRoomDoor.getSize();
      System.out.println(
          "                                                                          "
              + currentAmount);
      for (int i = 0; i < currentAmount; i++)
      {
        list.add(treasureRoomDoor.retrieveValuables());
        worth += list.get(i).getWorth();
        if (worth > limit)
        {
          break;
        }
      }
      if (worth >= limit)
      {
        System.out.println(
            "                                                                                      Party time");
        list.clear();
        System.out.println(
            "                                                                                        Im releasing the write");
        System.out.println("                                                                          "+treasureRoomDoor.getSize());
        treasureRoomDoor.releaseWrite();
        spendTime(6000);
      }
      if (worth < limit)
      {
        System.out.println(
            "                                                                                      Too poor for party "
                + worth);
        treasureRoomDoor.addValuables(list);

        System.out.println(
            "                                                                                        Im releasing the write");
        System.out.println("                                                                          "+treasureRoomDoor.getSize());
        treasureRoomDoor.releaseWrite();
        spendTime(2000);
      }
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

