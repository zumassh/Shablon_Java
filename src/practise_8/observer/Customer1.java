package practise_8.observer;

public class Customer1 implements Customer{
    @Override
    public void update(String color) {
        System.out.println("Новый трендовый цвет - " + color);
    }
}
