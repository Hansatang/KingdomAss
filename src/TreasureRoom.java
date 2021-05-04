import Valuables.Valuable;

import java.util.ArrayList;

public class TreasureRoom implements TreasureRoomDoor
{
  private ArrayList<Valuable> valuables;
  private int readers = 0;
  private int writers = 0;
  private int waitingWriter;

  public TreasureRoom()
  {
    valuables = new ArrayList<>();
  }

  @Override public synchronized void addValuables(
      ArrayList<Valuable> listOfValuables)
  {
    System.out.println(
        "Treasure add: Thread name " + Thread.currentThread().getName());
    System.out.println("\t\t\tI just added " + listOfValuables.size());
    valuables.addAll(listOfValuables);
  }

  @Override public synchronized Valuable retrieveValuables()
  {
    System.out.println(
        "Treasure retrieve: Thread name " + Thread.currentThread().getName());
    System.out
        .println("\t\t\tI just got " + valuables.get(0).getResourceType());
    return valuables.remove(0);
  }

  @Override public synchronized ArrayList<Valuable> lookAtValuables()
  {
    System.out.println(
        "Treasure look: Thread name " + Thread.currentThread().getName());
    return valuables;
  }

  @Override public synchronized int getSize()
  {
    System.out.println(
        "Treasure size: Thread name " + Thread.currentThread().getName());
    System.out.println("\t\t\tMy size " + valuables.size());
    return valuables.size();
  }

  @Override public synchronized void aquireRead()
  {

      System.out.println("\t\t\t\t\t\t\t\t\treaders " + readers);
      System.out.println("\t\t\t\t\t\t\t\t\twriters " + writers);
      System.out.println(
          "Treasure aread: Thread name " + Thread.currentThread().getName());
      while (writers > 0 || waitingWriter > 0)
      {
        try
        {
          System.out.println("Im'waiting");
          wait();
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      System.out.println("I'm done waiting");
      readers++;

  }

  @Override public synchronized void aquireWrite()
  {
    System.out.println(
        "Treasure awrite: Thread name " + Thread.currentThread().getName());
    waitingWriter++;
    System.out.println("\t\t\t\t\t\t\t\t\treaders " + readers);
    System.out.println("\t\t\t\t\t\t\t\t\twriters " + writers);
    while (readers > 0 || writers > 0)
    {
      try
      {
        System.out.println("WriteBlock");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingWriter--;
    writers++;
    System.out.println("AcquireWrite calls " + writers);
  }

  @Override public synchronized void releaseRead()
  {
    System.out.println(
        "Treasure rread: Thread name " + Thread.currentThread().getName());
    System.out.println("ReleaseRead calls ");
    readers--;
    if (readers == 0)
    {
      notify();
    }
  }

  @Override public synchronized void releaseWrite()
  {
    System.out.println(
        "Treasure rwrite: Thread name " + Thread.currentThread().getName());
    writers--;
    System.out.println("releaseWrite calls " + writers);
    notifyAll();
  }

  @Override public synchronized String toString()
  {
    return "TreasureRoom{" + "valuables=" + valuables + '}';
  }
}
