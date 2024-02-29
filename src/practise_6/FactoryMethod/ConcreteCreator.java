package practise_6.FactoryMethod;

public class ConcreteCreator extends Creator{
    public Product factoryMethod(){
        return new ConcreteProduct();
    }
}
