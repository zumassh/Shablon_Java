package practise_5;

public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    }

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

