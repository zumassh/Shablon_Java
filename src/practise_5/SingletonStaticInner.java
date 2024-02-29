package practise_5;

public class SingletonStaticInner {
    private SingletonStaticInner() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    }

    private static class SingletonHolder {
        private static final SingletonStaticInner instance = new SingletonStaticInner();
    }

    public static SingletonStaticInner getInstance() {
        return SingletonHolder.instance;
    }
}
