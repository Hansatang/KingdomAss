import Valuables.Valuable;

public class Miner implements Runnable
{
  private String name;
  private Valuable retrievedValuable;
  private Mine mine;
  private DepositInterface deposit;

  /** Miner constructor, requires a name, DepositInterface and Mine */
  public Miner(String name, Mine mine, DepositInterface deposit)
  {
    this.name = name;
    this.retrievedValuable = null;
    this.mine = mine;
    this.deposit = deposit;
  }

  /** A run method from Runnable interface */
  @Override public void run()
  {
    while (mine.getSize() != 0)
    {
      System.out.println("Miner " + name);
      retrievedValuable = mine.getResources();
      System.out.println("I mined " + retrievedValuable.getResourceType());
      work(200);
      try
      {
        deposit.addValuables(retrievedValuable);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      retrievedValuable = null;
    }
  }

  /** A method to simulate mining Valuables */
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
