import Valuables.Valuable;

import java.util.ArrayList;

public class ValuableTransport implements Runnable
{
  private ArrayList<Valuable> list;
  private int worth = 0;
  private int limit = (int) (Math.random() * 150 + 50);
  private Deposit deposit;

  public ValuableTransport(Deposit deposit)
  {
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
      System.out.println("I prepared for transport "+list.get(list.size() + 1).toString());
      work(100);
      worth += list.get(list.size() + 1).getWorth();
      if (worth > limit)
      {
        System.out.println(
            "delivered " + list.size() + "valuables and it was worth " + worth);
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
