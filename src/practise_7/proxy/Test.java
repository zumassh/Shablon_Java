package practise_7.proxy;

public class Test {
    public static void main(String[] args) {
        IDoc doc = new DocumentProxy();
        doc.create();
        try {
            doc.download();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        doc.delete();
    }
}
