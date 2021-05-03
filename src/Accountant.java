import Valuables.Valuable;

import java.util.ArrayList;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoomDoor;
  private int sum;
  private ArrayList<Valuable> list;
  private Logger logger;

  public Accountant(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
    this.list = new ArrayList<>();
    this.sum = 0;
    this.logger = Logger.getInstance();

  }

  @Override public void run()
  {
    while (true)
    {
      treasureRoomDoor.aquireRead();
      int currentAmount = treasureRoomDoor.getSize();
      list = treasureRoomDoor.lookAtValuables();
      for (int i = 0; i < currentAmount; i++)
      {
        sum += list.get(i).getWorth();
        spendTime(10);
      }

      logger.log("\n"+sum);
      treasureRoomDoor.releaseRead();
      spendTime(5000);

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
