import Valuables.Valuable;

import java.util.ArrayList;

public class TreasureRoom implements TreasureRoomDoor
{
  private ArrayList<Valuable> valuables;
  private int l = 0;
  private int k = 0;
  private int readers = 0;
  private int writers = 0;
  private boolean waitingWriter;

  public TreasureRoom()
  {
    valuables = new ArrayList<>();
  }

  @Override synchronized public void addValuables(ArrayList<Valuable> listOfValuables)
  {
    System.out.println("Treasure add: Thread name " + Thread.currentThread().getName());
    System.out.println("\t\t\tI just added "+listOfValuables.size());
    valuables.addAll(listOfValuables);
  }

  @Override strictfp public Valuable retrieveValuables()
  {
    System.out.println("Treasure retrieve: Thread name " + Thread.currentThread().getName());
    System.out.println("\t\t\tI just gave back "+ valuables.get(0).getResourceType());
    return valuables.remove(0);
  }

  @Override synchronized public ArrayList<Valuable> lookAtValuables()
  {
    System.out.println("Treasure look: Thread name " + Thread.currentThread().getName());
    return valuables;
  }

  @Override synchronized public int getSize()
  {
    System.out.println("Treasure size: Thread name " + Thread.currentThread().getName());
    System.out.println("\t\t\tMy size "+valuables.size());
    return valuables.size();
  }

  @Override synchronized public void aquireRead()
  {
    System.out.println("Treasure aread: Thread name " + Thread.currentThread().getName());
    k++;
    System.out.println("AcquireRead calls " + k);
    while (writers > 0 || waitingWriter)
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

  @Override synchronized public void aquireWrite()
  {
    System.out.println("Treasure awrite: Thread name " + Thread.currentThread().getName());
    waitingWriter = true;
    while (readers > 0 || writers > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingWriter = false;
    writers++;
    System.out.println("AcquireWrite calls " + writers);
  }

  @Override synchronized public void releaseRead()
  {
    System.out.println("Treasure rread: Thread name " + Thread.currentThread().getName());
    System.out.println("ReleaseRead calls ");
    readers--;
    if (readers == 0)
    {
      notifyAll();
    }
  }

  @Override synchronized public void releaseWrite()
  {
    System.out.println("Treasure rwrite: Thread name " + Thread.currentThread().getName());
    writers--;
    System.out.println("releaseWrite calls " + writers);
    notifyAll();
  }

  @Override public String toString()
  {
    return "TreasureRoom{" + "valuables=" + valuables + '}';
  }
}
