package practise_8.state;

public class Stopped implements State{
    private State context;
    @Override
    public void doSmth() {
        System.out.println("Трек остановлен.");
    }
    public void setContext(State context) {
        this.context = context;
    }
}
