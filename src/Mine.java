import Valuables.ResourceType;
import Valuables.Valuable;

import java.util.ArrayList;

public class Mine
{

  private ArrayList<Valuable> resources;


  public Mine()
  {
    this.resources = new ArrayList<>();
    for (int i = 0; i < 100; i++)
    {
      int random = (int) (Math.random() * 3 + 1);
      if (random == 1)
      {
        resources.add(Valuable.getInstance(ResourceType.IRON));
      }
      else if (random == 2)
      {

        resources.add(Valuable.getInstance(ResourceType.DIAMOND));
      }
      else
      {
        resources.add(Valuable.getInstance(ResourceType.GOLD));
      }
    }
  }

  public synchronized Valuable getResources()
  {
    int random = (int) (Math.random() * resources.size() - 1);
    return resources.get(random);
  }
}
