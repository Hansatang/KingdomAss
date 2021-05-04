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
    Thread t2 = new Thread(m2);

    ValuableTransport vT1 = new ValuableTransport("Johnatan", deposit, guard);
    ValuableTransport vT2 = new ValuableTransport("Hands", deposit, guard);
    Thread t3 = new Thread(vT1);
    Thread t4 = new Thread(vT2);

    King king = new King(guard);
    Thread t5 = new Thread(king);

    Accountant accountant1 = new Accountant(guard);
    Thread t6 = new Thread(accountant1);
    Accountant accountant2 = new Accountant(guard);
    Thread t7 = new Thread(accountant2);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
//    t6.start();
//   t7.start();
  }
}
