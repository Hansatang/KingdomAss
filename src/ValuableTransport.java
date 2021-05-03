import Valuables.Valuable;

import java.util.ArrayList;

public class ValuableTransport implements Runnable
{
  private ArrayList<Valuable> list;
  private String name;
  private int worth = 0;
  private int limit = (int) (Math.random() * 150 + 50);
  private DepositInterface deposit;

  public ValuableTransport(String name,DepositInterface deposit)
  {
    this.name=name;
    this.list = new ArrayList<>();
    this.deposit = deposit;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        list.add(deposit.getValuables());
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Me, "+name +" prepared for transport " + list.get(list.size() - 1)
          .getResourceType() + " but I need " + (limit - worth) + " more");
      work(50);
      worth += list.get(list.size() - 1).getWorth();
      if (worth > limit)
      {
        System.out.println(
            "Delivered " + list.size() + " valuables and it was worth "
                + worth+"to the treasury");

        worth = 0;
      }
    }
  }

  private void work(int sleepTime)
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
