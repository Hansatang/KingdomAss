import Valuables.Valuable;

public class Miner implements Runnable
{
  private String name;
  private Valuable valuable;
  private Mine mine;
  private Deposit deposit;

  public Miner(String name, Valuable valuable, Mine mine, Deposit deposit)
  {
    this.name = name;
    this.valuable = valuable;
    this.mine = mine;
    this.deposit = deposit;
  }

  @Override public void run()
  {
    while (true)
    {
      valuable = mine.getResources();
      work(100);
      deposit.depositValuables();
      valuable = null;

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
