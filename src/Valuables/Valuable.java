package Valuables;

import java.util.HashMap;
import java.util.Map;

public class Valuable
{
  private static Map<String, Valuable> allInstances = new HashMap<>();

  public int getWorth()
  {
    return 0;
  }

  public static Valuable getInstance(String key)
  {
    Valuable instance = allInstances.get(key);
    if (instance == null)
    {
      synchronized (allInstances)
      {
        instance = allInstances.get(key);
        if (instance == null)
        {
          instance = new Valuable();
          allInstances.put(key, instance);
        }
      }
    }
    return instance;
  }
}
