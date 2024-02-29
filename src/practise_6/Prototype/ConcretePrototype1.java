package practise_6.Prototype;

public class ConcretePrototype1 implements Prototype{
    String name;

    public ConcretePrototype1(String name){
        this.name = name;
    }

    ConcretePrototype1(ConcretePrototype1 proto1){
        this.name = proto1.name;
    }
    @Override
    public Prototype clone() {
        return new ConcretePrototype1(this);
    }

    public String getName() {
        return name;
    }
}
