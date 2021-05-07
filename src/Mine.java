import Valuables.ResourceType;
import Valuables.Valuable;

import java.util.ArrayList;

public class Mine
{

  private ArrayList<Valuable> resources;

  /** Mine constructor, it populates the ArrayList with Valuables */
  public Mine()
  {
    this.resources = new ArrayList<>();
    for (int i = 0; i < 10000; i++)
    {
      int random = (int) (Math.random() * 3 + 1);
      if (random == 1)
      {
        System.out.println("Add iron");
        resources.add(Valuable.getInstance(ResourceType.IRON));
      }
      else if (random == 2)
      {
        System.out.println("Add gold");
        resources.add(Valuable.getInstance(ResourceType.GOLD));
      }
      else
      {
        System.out.println("Add diamond");
        resources.add(Valuable.getInstance(ResourceType.DIAMOND));
      }
    }
  }

  /** Method for removing pseudo random item from ArrayList of Valuables */
  public synchronized Valuable getResources()
  {
    System.out.println(getSize());
    int random = (int) (Math.random() * resources.size() - 1);
    return resources.remove(random);
  }

  /** Method for getting the size of ArrayList of Valuables */
  public synchronized int getSize()
  {
    return resources.size();
  }
}
