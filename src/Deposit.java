import Valuables.Valuable;

import java.util.ArrayList;

public class Deposit implements DepositInterface
{
  private ArrayList<Valuable> resources;
  private int max = 50;

  public Deposit()
  {
    this.resources = new ArrayList<>();
  }

  @Override public void addValuables(Valuable retrievedValuable)
      throws InterruptedException
  {
    synchronized (this)
    {
      while (resources.size() == max)
      {
        System.out.println("Deposit block");
        wait();
        System.out.println("After block");
      }
      if (retrievedValuable == null)
      {
        throw new IllegalStateException("Variable is null");
      }
      else
      {
        System.out.println("Deposit unlock");
        resources.add(retrievedValuable);
      }
      notifyAll();
    }
  }

  @Override public Valuable getValuables() throws InterruptedException
  {
    synchronized (this)
    {
      while (resources.size() == 0)
      {
        System.out.println("Transport is waiting");
        wait();
      }
      System.out.println("Notify all miners");
      notifyAll();
      Valuable valuable = resources.get(resources.size() - 1);
      resources.remove(resources.size() - 1);
      return valuable;
    }
  }

  public int getMax()
  {
    return max;
  }
}
