package Valuables;


import java.util.HashMap;
import java.util.Map;

public class Valuable {
    private ResourceType resource;
    private static Map<ResourceType, Valuable> allInstances = new HashMap<ResourceType, Valuable>();


    private Valuable(ResourceType resourceType) {
        this.resource = resourceType;
    }

    public int getWorth(ResourceType resourceType) {
        int worth = 0;
        if (getInstance(ResourceType.GOLD).equals(resourceType)) {
            worth = 5;
        } else if (getInstance(ResourceType.IRON).equals(resourceType)) {
            worth = 3;
        } else if (getInstance(ResourceType.DIAMOND).equals(resourceType)) {
            worth = 7;
        }
        return worth;
    }


    public static Valuable getInstance(ResourceType resourceType) {
        Valuable instance = allInstances.get(resourceType);
        if (instance == null) {
            synchronized (allInstances) {
                instance = allInstances.get(resourceType);
                if (instance == null) {
                    instance = new Valuable(resourceType);
                    allInstances.put(resourceType, instance);
                }
            }
        }
        return instance;
    }
}
