package g13c.cw5.zad2;

public class Root extends Plant {

    public Root(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    public int getReagent(){
        return (super.getReagent() / 2);
    }
}
