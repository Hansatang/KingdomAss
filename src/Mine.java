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
        resources.add();
      }
      else if (random == 2)
      {
        resources.add();
      }
      else
      {
        resources.add();
      }
    }
  }

  public synchronized Valuable getResources()
  {
    int random = (int) (Math.random() * resources.size() - 1);
    return resources.get(random);
  }
}
