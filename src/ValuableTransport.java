import Valuables.Valuable;

import java.util.ArrayList;

public class ValuableTransport implements Runnable
{
  private ArrayList<Valuable> list;
  private int worth = 0;
  private int limit = (int) (Math.random() * 150 + 50);
  private Deposit deposit;

  @Override public void run()
  {
    while (true)
    {
      list.add(deposit.getResource());
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
