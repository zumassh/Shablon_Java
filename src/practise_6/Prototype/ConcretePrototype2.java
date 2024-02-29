package practise_6.Prototype;

public class ConcretePrototype2 implements Prototype{
    Integer code;
    public  ConcretePrototype2(Integer code){
        this.code = code;
    }

    ConcretePrototype2(ConcretePrototype2 proto2){
        this.code = proto2.code;
    }
    @Override
    public Prototype clone() {
        return new ConcretePrototype2(this);
    }

    public Integer getCode() {
        return code;
    }
}
