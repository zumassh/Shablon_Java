package practise_8.observer;

public class Main {
    public static void main(String[] args) {
        FasionHouse gucci = new FasionHouse("зеленый");
        Customer1 lady = new Customer1();
        Customer2 punk = new Customer2();
        gucci.subscribe(lady);
        gucci.subscribe(punk);
        gucci.changeTrendColor();

        gucci.unsubscribe(punk);
        gucci.changeTrendColor();
    }
}
