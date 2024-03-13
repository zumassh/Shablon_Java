package practise_8.state;

public class Paused implements State{
    private State context;
    @Override
    public void doSmth() {
        System.out.println("Трек на паузе");
    }
    public void setContext(State context){
        this.context = context;
    }
}
