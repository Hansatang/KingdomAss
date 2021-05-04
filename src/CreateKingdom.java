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
    Miner m3 = new Miner("Olo", mine, deposit);
    Miner m4 = new Miner("Qaz", mine, deposit);
    Miner m5 = new Miner("Terry", mine, deposit);
    Thread tm1 = new Thread(m1);
    tm1.setName("John");
    Thread tm2 = new Thread(m2);
    tm2.setName("Mike");
    Thread tm3 = new Thread(m3);
    tm2.setName("Olo");
    Thread tm4 = new Thread(m4);
    tm2.setName("Qaz");
    Thread tm5 = new Thread(m5);
    tm2.setName("Terry");

    ValuableTransport vT1 = new ValuableTransport("Johnatan", deposit, guard);
    ValuableTransport vT2 = new ValuableTransport("Hands", deposit, guard);
    ValuableTransport vT3 = new ValuableTransport("Carrier", deposit, guard);
    Thread tvT1 = new Thread(vT1);
    tvT1.setName("Johnatan");
    Thread tvT2 = new Thread(vT2);
    tvT2.setName("Hands");
    Thread tvT3 = new Thread(vT3);
    tvT3.setName("Carrier");

    King king = new King(guard);
    Thread t5 = new Thread(king);
    t5.setName("King");

    Accountant accountant1 = new Accountant(guard,"Ham");
    Thread t6 = new Thread(accountant1);
    t6.setName("accountant 1");
    Accountant accountant2 = new Accountant(guard,"Cheese");
    Thread t7 = new Thread(accountant2);
    t7.setName("accountant 2");

    tm1.start();
    tm2.start();
    tm3.start();
    tm4.start();
    tm5.start();
    tvT1.start();
    tvT2.start();
    tvT3.start();
    t5.start();
    t6.start();
    t7.start();

  }
}
