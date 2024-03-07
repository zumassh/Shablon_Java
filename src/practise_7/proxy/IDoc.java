package practise_7.proxy;

public interface IDoc {
    public void create();
    public void download() throws InterruptedException;
    public void delete();
}
