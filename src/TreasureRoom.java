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

  @Override public void addValuables(ArrayList<Valuable> listOfValuables)
  {
    System.out.println("\t\t\tI just added "+listOfValuables.size());
    valuables.addAll(listOfValuables);
  }

  @Override public Valuable retrieveValuables()
  {
    System.out.println("\t\t\tI just gave back "+ valuables.get(0).getResourceType());
    return valuables.remove(0);
  }

  @Override public ArrayList<Valuable> lookAtValuables()
  {
    return valuables;
  }

  @Override public int getSize()
  {
    System.out.println("\t\t\tMy size "+valuables.size());
    return valuables.size();
  }

  @Override synchronized public void aquireRead()
  {
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
    System.out.println("ReleaseRead calls ");
    readers--;
    if (readers == 0)
    {
      notifyAll();
    }
  }

  @Override synchronized public void releaseWrite()
  {
    writers--;
    System.out.println("releaseWrite calls " + writers);
    notifyAll();
  }

  @Override public String toString()
  {
    return "TreasureRoom{" + "valuables=" + valuables + '}';
  }
}
