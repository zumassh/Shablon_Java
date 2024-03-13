package practise_8.observer;

public class Customer2 implements Customer{
    @Override
    public void update(String color) {
        System.out.println("Мы панки! Не надевайте " + color + " цвет!");
    }
}
