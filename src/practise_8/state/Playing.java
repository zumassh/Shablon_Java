package practise_8.state;

public class Playing implements State{
    private State context;
    @Override
    public void doSmth() {
        System.out.println("Трек играет");
    }
    public void setContext(State context){
        this.context = context;
    }
}
