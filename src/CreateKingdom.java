public class CreateKingdom
{
  public static void main(String[] args)
  {
    Mine mine = new Mine();
    Deposit deposit = new Deposit();
    Miner m1 = new Miner("John",mine,deposit);
    Miner m2 = new Miner("Mike",mine,deposit);
    Thread t1 = new Thread(m1);
    Thread t2 = new Thread(m2);

    ValuableTransport vT1 = new ValuableTransport(deposit);
    ValuableTransport vT2 = new ValuableTransport(deposit);
    Thread t3 = new Thread(vT1);
    Thread t4 = new Thread(vT2);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
