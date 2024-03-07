package practise_7.proxy;

public class Document implements IDoc{
    @Override
    public void create() {
        System.out.println("Документ создан");
    }

    @Override
    public void download() throws InterruptedException {
        System.out.println("Скачивание документа..");
        Thread.sleep(2000);
        System.out.println("Скачивание успешно завершено.");
    }

    @Override
    public void delete() {
        System.out.println("Документ удален");
    }
}
