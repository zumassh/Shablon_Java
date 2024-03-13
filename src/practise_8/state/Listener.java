package practise_8.state;

public class Listener {
    public static void main(String[] args) {
        Playing play = new Playing();
        Music mus = new Music(play);
        mus.doSmth();
    }
}
