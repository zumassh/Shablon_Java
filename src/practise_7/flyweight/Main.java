package practise_7.flyweight;

public class Main {
    public static void main(String[] args) {
        HouseFlyweightFactory factory = new HouseFlyweightFactory();

        HouseFlyweight sharedHouse1 = factory.getHouseFlyweight(2, 3);
        sharedHouse1.display("123 Main St");

        HouseFlyweight sharedHouse2 = factory.getHouseFlyweight(2, 3);
        sharedHouse2.display("456 Elm St");

        HouseFlyweight unsharedHouse = new UnsharedHouseFlyweight("789 Oak St", 250000.0);
        unsharedHouse.display("");
    }
}