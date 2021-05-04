import Valuables.Valuable;

import java.util.ArrayList;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoomDoor;
  private int sum;
  private ArrayList<Valuable> list;
  private Logger logger;
  private String name;

  public Accountant(TreasureRoomDoor treasureRoomDoor,String name)
  {
    this.treasureRoomDoor = treasureRoomDoor;
    this.list = new ArrayList<>();
    this.sum = 0;
    this.logger = Logger.getInstance();
    this.name=name;

  }

  @Override public void run()
  {
    while (true)
    {
      System.out.println("Accountant "+name);
      treasureRoomDoor.aquireRead();
      list = treasureRoomDoor.lookAtValuables();
      System.out.println(list.size());
      for (Valuable valuable : list)
      {
        sum += valuable.getWorth();
      }
    //  spendTime(list.size());
      treasureRoomDoor.releaseRead();
     spendTime(list.size());

      logger.log("\n" +name+" "+ sum);
      spendTime((int) (Math.random() * 2000 + 1001));
    }
  }

  public void spendTime(int sleepTime)
  {
    try
    {
      System.out.println("Accountant is waiting");
      Thread.sleep(sleepTime);
      System.out.println("Accountant is done waiting");
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

}
