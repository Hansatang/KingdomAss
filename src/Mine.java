import Valuables.ResourceType;
import Valuables.Valuable;

import java.util.ArrayList;

public class Mine
{

  private ArrayList<Valuable> resources;

  public Mine()
  {
    this.resources = new ArrayList<>();
    for (int i = 0; i < 1; i++)
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

  public synchronized Valuable getResources()
  {
    int random = (int) (Math.random() * resources.size() - 1);
    return resources.get(random);
  }
}
