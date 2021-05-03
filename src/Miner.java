import Valuables.Valuable;

public class Miner implements Runnable
{
  private String name;
  private Valuable retrievedValuable;
  private Mine mine;
  private Deposit deposit;

  public Miner(String name, Valuable valuable, Mine mine, Deposit deposit)
  {
    this.name = name;
    this.retrievedValuable = valuable;
    this.mine = mine;
    this.deposit = deposit;
  }

  @Override public void run()
  {
    while (true)
    {
      retrievedValuable = mine.getResources();
      System.out.println("I mined "+retrievedValuable);
      work(100);
      deposit.addValuables(retrievedValuable);
      retrievedValuable = null;

    }
  }


  private void work(int sleepTime) {
    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
