package practise_6;

import practise_6.AbstractFactory.AbstractFactory;
import practise_6.AbstractFactory.Client;
import practise_6.AbstractFactory.ConcreteFactory1;
import practise_6.AbstractFactory.ConcreteFactory2;
import practise_6.Builder.Builder;
import practise_6.Builder.ConcreteBuilder;
import practise_6.Builder.Director;
import practise_6.FactoryMethod.ConcreteCreator;
import practise_6.FactoryMethod.ConcreteProduct;
import practise_6.FactoryMethod.Creator;
import practise_6.FactoryMethod.Product;
import practise_6.Prototype.ConcretePrototype1;
import practise_6.Prototype.ConcretePrototype2;
import practise_6.Prototype.Prototype;

public class Test {
    public static void main(String[] args) {
        Creator hum = new ConcreteCreator();
        hum.anOperation();
        Product humus = hum.factoryMethod();

        AbstractFactory f1 = new ConcreteFactory1();
        AbstractFactory f2 = new ConcreteFactory2();
        Client client1 = new Client(f1);
        Client client2 = new Client(f2);
        client1.someOperation();
        client2.someOperation();

        Builder b = new ConcreteBuilder();
        Director d = new Director(b);
        d.construct();

        Prototype pr1 = new ConcretePrototype1("Goga");
        Prototype pr2 = new ConcretePrototype2(123);
        Prototype copyPr1 = pr1.clone();
        Prototype copyPr2 = pr2.clone();

        System.out.println(((ConcretePrototype1)pr1).getName());
        System.out.println(((ConcretePrototype1)copyPr1).getName());
        System.out.println(((ConcretePrototype2)pr2).getCode());
        System.out.println(((ConcretePrototype2)copyPr2).getCode());
    }
}
