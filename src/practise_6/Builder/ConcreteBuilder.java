package practise_6.Builder;

public class ConcreteBuilder implements Builder{
    @Override
    public void buildRoof() {
        System.out.println("Крыша построена.");
    }

    @Override
    public void buildWall() {
        System.out.println("Стена возведена.");
    }

    @Override
    public void buildFloor() {
        System.out.println("Пол готов.");
    }
}
