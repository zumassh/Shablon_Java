package practise_7.proxy;

public class DocumentProxy implements IDoc{
    private Document doc;

    @Override
    public void create() {
        checkIn();
        doc.create();
    }

    @Override
    public void download() throws InterruptedException {
        checkIn();
        doc.download();
    }

    @Override
    public void delete() {
        checkIn();
        doc.delete();
    }

    public void checkIn(){
        if (doc == null){
            doc = new Document();
        }
        System.out.println("Проверка документа.");
    }
}
