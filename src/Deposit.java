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
    System.out.println(
        "Deposit add: Thread name " + Thread.currentThread().getName());
    synchronized (this)
    {
      while (resources.size() == max)
      {
        System.out.println("Deposit block");
        wait();
        System.out.println("After block");
      }
      System.out.println("Deposit unlock");
      resources.add(retrievedValuable);
      notifyAll();
    }
  }

  @Override public Valuable getValuables() throws InterruptedException
  {
    System.out.println(
        "Deposit get: Thread name " + Thread.currentThread().getName());
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
