import Valuables.Valuable;

import java.util.ArrayList;

public class Accountant implements Runnable
{
  /** Declare objects **/
  private TreasureRoomDoor treasureRoomDoor;
  private int sum;
  private ArrayList<Valuable> list;
  private Logger logger;

  /** Constructor that takes treasureRoomDoor as a parameter **/
  public Accountant(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
    this.list = new ArrayList<>();
    this.sum = 0;
    this.logger = Logger.getInstance();

  }

  /** Calculates sum for the accountant **/

  @Override public void run()
  {
    while (true)
    {
      System.out.println("Accountant");
      treasureRoomDoor.aquireRead();
      list = treasureRoomDoor.lookAtValuables();
      treasureRoomDoor.releaseRead();
      for (int i = 0; i < list.size(); i++)
      {
        sum += list.get(i).getWorth();
        spendTime(1);
      }
      //      treasureRoomDoor.releaseRead();
      logger.log("\n" + sum);
      spendTime((int) (Math.random() * 4000 + 1000));
    }
  }

  /** Method to simulate time **/

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
