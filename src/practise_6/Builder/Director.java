package practise_6.Builder;

public class Director {
    Builder boba;
    public Director(Builder builder){
        this.boba = builder;
    }
    public void construct(){
        boba.buildFloor();
        boba.buildRoof();
        boba.buildWall();
    }
}
