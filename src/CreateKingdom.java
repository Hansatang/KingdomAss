public class CreateKingdom
{
  public static void main(String[] args)
  {
    Mine mine = new Mine();
    DepositInterface deposit = new Deposit();
    TreasureRoomDoor treasureRoom = new TreasureRoom();
    TreasureRoomDoor guard = new Guard(treasureRoom);
    Miner m1 = new Miner("John", mine, deposit);
    Miner m2 = new Miner("Mike", mine, deposit);
    Thread t1 = new Thread(m1);
    t1.setName("John");
    Thread t2 = new Thread(m2);
    t2.setName("Mike");

    ValuableTransport vT1 = new ValuableTransport("Johnatan", deposit, guard);
    ValuableTransport vT2 = new ValuableTransport("Hands", deposit, guard);
    Thread t3 = new Thread(vT1);
    t3.setName("Johnatan");
    Thread t4 = new Thread(vT2);
    t4.setName("Hands");

    King king = new King(guard);
    Thread t5 = new Thread(king);
    t5.setName("King");

    Accountant accountant1 = new Accountant(guard);
    Thread t6 = new Thread(accountant1);
    t6.setName("accountant 1");
    Accountant accountant2 = new Accountant(guard);
    Thread t7 = new Thread(accountant2);
    t7.setName("accountant 2");

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
  }
}
