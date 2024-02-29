package practise_5;

public class Main {
    public static void main(String[] args) {
        // Тест для SingletonLazy
        SingletonLazy lazyInstance1 = SingletonLazy.getInstance();
        SingletonLazy lazyInstance2 = SingletonLazy.getInstance();

        System.out.println("SingletonLazy:");
        System.out.println("Instance 1 hashCode: " + lazyInstance1.hashCode());
        System.out.println("Instance 2 hashCode: " + lazyInstance2.hashCode());

        // Тест для SingletonEager
        SingletonEager eagerInstance1 = SingletonEager.getInstance();
        SingletonEager eagerInstance2 = SingletonEager.getInstance();

        System.out.println("\nSingletonEager:");
        System.out.println("Instance 1 hashCode: " + eagerInstance1.hashCode());
        System.out.println("Instance 2 hashCode: " + eagerInstance2.hashCode());

        // Тест для SingletonStaticInner
        SingletonStaticInner staticInnerInstance1 = SingletonStaticInner.getInstance();
        SingletonStaticInner staticInnerInstance2 = SingletonStaticInner.getInstance();

        System.out.println("\nSingletonStaticInner:");
        System.out.println("Instance 1 hashCode: " + staticInnerInstance1.hashCode());
        System.out.println("Instance 2 hashCode: " + staticInnerInstance2.hashCode());
    }
}

