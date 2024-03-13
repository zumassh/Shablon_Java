package practise_8.state;

public class Music {
    private State state;

    public Music(State state) {
        this.state = state;
    }

    public void changeState(State state){
        this.state = state;
    }

    public void doSmth(){
        state.doSmth();
    }
}
