import Valuables.Valuable;

import java.util.ArrayList;

public class Deposit
{
  private ArrayList<Valuable> resources;
  private int max = 10;

  public Deposit()
  {
    this.resources = new ArrayList<>();
  }

  public void addValuables(Valuable retrievedValuable)
      throws InterruptedException
  {
    synchronized (this)
    {
      while (resources.size() == max)
      {
        wait();
      }
      resources.add(retrievedValuable);
      notifyAll();
    }

  }

  public synchronized Valuable getValuables() throws InterruptedException
  {
    synchronized (this)
    {
      while (resources.size() == 0)
      {

        wait();
      }
      notifyAll();
      Valuable valuable = resources.get(resources.size() - 1);
      resources.remove(resources.size() - 1);
      return valuable;
    }
  }
}
