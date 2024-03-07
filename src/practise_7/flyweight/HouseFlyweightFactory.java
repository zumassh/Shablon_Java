package practise_7.flyweight;

import java.util.HashMap;

class HouseFlyweightFactory {
    private HashMap<String, HouseFlyweight> flyweights = new HashMap<>();

    public HouseFlyweight getHouseFlyweight(int floors, int rooms) {
        String key = floors + "-" + rooms;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteHouseFlyweight(floors, rooms));
        }
        return flyweights.get(key);
    }
}
