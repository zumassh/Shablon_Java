package practise_6.AbstractFactory;

public class Client {
    private AbstractProductA apA;
    private AbstractProductB apB;

    public Client(AbstractFactory fab) {
        apA = fab.createProductA();
        apB = fab.createProductB();
    }

    public void someOperation(){
        System.out.println(apA.getClass().getName() + " " + apB.getClass().getName());
    }
}
