import Valuables.Valuable;

import java.util.ArrayList;

public class Mine
{

  private ArrayList<Valuable> resources;

  public synchronized Valuable getResources()
  {
    int random = (int) (Math.random() * resources.size() - 1);
    return resources.get(random);
  }
}
