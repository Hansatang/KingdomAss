package Valuables;


import java.util.HashMap;
import java.util.Map;

public class Valuable
{
    /** Declare objects **/
    private ResourceType resource;
    private static Map<ResourceType, Valuable> allInstances = new HashMap<ResourceType, Valuable>();
    private int worth;

    /** Private constructor, requires a resource type **/
    private Valuable(ResourceType resourceType)
    {
        this.resource = resourceType;
        this.worth = getWorth(resourceType);
    }

    /** Get method for worth, takes resourceType as parameter **/
    private int getWorth(ResourceType resourceType)
    {
        int worth = 0;
        if (ResourceType.GOLD.equals(resourceType))
        {
            worth = 5;
        }
        else if (ResourceType.IRON.equals(resourceType))
        {
            worth = 3;
        }
        else if (ResourceType.DIAMOND.equals(resourceType))
        {
            worth = 7;
        }
        return worth;
    }

    /** Get method for worth **/
    public int getWorth()
    {
        return worth;
    }

    /** Get method for resourceType **/
    public ResourceType getResourceType()
    {
        return resource;
    }

    /** static method that returns an object of this class **/
    public static Valuable getInstance(ResourceType resourceType)
    {
        Valuable instance = allInstances.get(resourceType);
        if (instance == null)
        {
            synchronized (allInstances)
            {
                instance = allInstances.get(resourceType);
                if (instance == null)
                {
                    instance = new Valuable(resourceType);
                    allInstances.put(resourceType, instance);
                }
            }
        }
        return instance;
    }
}
