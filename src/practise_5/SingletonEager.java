package practise_5;

public class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    }

    public static SingletonEager getInstance() {
        return instance;
    }
}
