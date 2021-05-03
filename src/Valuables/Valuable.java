package Valuables;


import java.util.HashMap;
import java.util.Map;

public class Valuable {
    private ResourceType resource;
    private static Map<ResourceType, Valuable> allInstances = new HashMap<ResourceType, Valuable>();
    private int worth;

    private Valuable(ResourceType resourceType) {
        this.resource = resourceType;
        this.worth = getWorth(resourceType);
    }

    private int getWorth(ResourceType resourceType) {
        int worth = 0;
        if (ResourceType.GOLD.equals(resourceType)) {
            worth = 5;
        } else if (ResourceType.IRON.equals(resourceType)) {
            worth = 3;
        } else if (ResourceType.DIAMOND.equals(resourceType)) {
            worth = 7;
        }
        return worth;
    }

    public int getWorth() {
        return worth;
    }

    public ResourceType getResourceType(){
        return resource;
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
