package g13c.cw5.zad2;

public class Ore extends Mineral {

    protected boolean metallic = false;

    public Ore(String name, int baseReagent, int power, boolean metallic) {
        super(name, baseReagent, power);
        setMetallic(metallic);
    }

    public boolean isMetallic() {
        return metallic;
    }

    public void setMetallic(boolean metallic) {
        this.metallic = metallic;
    }

    public int getReagent(){
        if(isMetallic()) {
            return (super.getReagent());
        } else {
            return (super.getReagent() / 2);
        }
    }
}
