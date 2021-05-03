import Valuables.Valuable;

import java.util.ArrayList;

public class TreasureRoom implements TreasureRoomDoor
{
  private ArrayList<Valuable> valuables;
  private int l = 0;
  private int k = 0;
  private int readers = 0;
  private int writers = 0;
  private int waitingWriters;

  public TreasureRoom()
  {
    valuables = new ArrayList<>();
  }

  @Override public void addValuables(ArrayList<Valuable> listOfValuables)
  {
    System.out.println("                                          I just added "+listOfValuables.size());
    valuables.addAll(listOfValuables);
  }

  @Override public Valuable retrieveValuables()
  {
    System.out.println("                                          I just gave back "+ valuables.get(0).getResourceType());
    return valuables.remove(0);
  }

  @Override public ArrayList<Valuable> lookAtValuables()
  {
    return valuables;
  }

  @Override public int getSize()
  {
    System.out.println("                                                                                                                          MY size "+valuables.size());
    return valuables.size();
  }

  @Override public void aquireRead()
  {
    k++;
    System.out.println("acquireRead calls " + k);
    while (writers > 0 || waitingWriters > 0)
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

  @Override public void aquireWrite()
  {
    waitingWriters++;
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
    waitingWriters--;
    writers++;
    System.out.println("acquireWrite calls " + writers);
  }

  @Override synchronized public void releaseRead()
  {
    System.out.println("releaseRead calls ");
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
