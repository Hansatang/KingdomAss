import Valuables.Valuable;

import java.util.ArrayList;

public class ValuableTransport implements Runnable
{
  private ArrayList<Valuable> list;
  private String name;
  private int worth = 0;
  private int limit = (int) (Math.random() * 150 + 50);
  private DepositInterface deposit;
  private TreasureRoomDoor treasureRoomDoor;

  /** ValuableTransport constructor, requires a name, DepositInterface and TreasureRoomDoor */
  public ValuableTransport(String name, DepositInterface deposit,
      TreasureRoomDoor treasureRoomDoor)
  {
    this.name = name;
    this.list = new ArrayList<>();
    this.deposit = deposit;
    this.treasureRoomDoor = treasureRoomDoor;
  }

  /** A run method from Runnable interface */
  @Override public void run()
  {
    while (true)
    {
      System.out.println("Transport");
      try
      {
        list.add(deposit.getValuables());
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println(
          "Me, " + name + " prepared for transport " + list.get(list.size() - 1)
              .getResourceType() + " but I need " + (limit - worth) + " more");
      // work(50);
      worth += list.get(list.size() - 1).getWorth();
      if (worth > limit)
      {
        System.out.println("\t\t\tIm asking for write to deliver");
        treasureRoomDoor.aquireWrite();
        System.out.println("Delivered by " + name + ": " + list.size()
            + " valuables and it was worth " + worth + "to the treasury");
        treasureRoomDoor.addValuables(list);
        treasureRoomDoor.releaseWrite();
        System.out.println("Complete delivery");
        list.clear();
        worth = 0;
        work(5000);
        System.out.println(name + ": End of delivery");
      }
    }
  }

  /** A method to simulate delivering Valuables */
  private void work(int sleepTime)
  {
    try
    {
      System.out.println("I'm waiting " + name);
      Thread.sleep(sleepTime);
      System.out.println("I'm done " + sleepTime + name);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
