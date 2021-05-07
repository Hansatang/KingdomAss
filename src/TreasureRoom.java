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

  /** Method for adding ArrayList of Valuables to existing ArrayList */
  @Override public synchronized void addValuables(
      ArrayList<Valuable> listOfValuables)
  {
    System.out.println("\t\t\tI just added " + listOfValuables.size());
    valuables.addAll(listOfValuables);
  }

  /** Method for removing first item from ArrayList of Valuables */
  @Override public synchronized Valuable retrieveValuables()
  {
    System.out
        .println("\t\t\tI just got " + valuables.get(0).getResourceType());
    return valuables.remove(0);
  }

  /** Method for getting ArrayList of Valuables to existing ArrayList */
  @Override public synchronized ArrayList<Valuable> lookAtValuables()
  {
    return valuables;
  }

  /** Method for getting the size of ArrayList of Valuables */
  @Override public synchronized int getSize()
  {
    System.out.println("\t\t\tMy size " + valuables.size());
    return valuables.size();
  }

  /** Method for acquiring Read access */
  @Override public synchronized void aquireRead()
  {
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

  /** Method for acquiring Write access */
  @Override public synchronized void aquireWrite()
  {
    waitingWriter++;
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

  /** Method for releasing Read access */
  @Override public synchronized void releaseRead()
  {
    System.out.println("ReleaseRead calls ");
    readers--;
    if (readers == 0)
    {
      notify();
    }
  }

  /** Method for releasing Write access */
  @Override public synchronized void releaseWrite()
  {
    writers--;
    System.out.println("releaseWrite calls " + writers);
    notifyAll();
  }
}
