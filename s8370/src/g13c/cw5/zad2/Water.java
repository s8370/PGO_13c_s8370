package g13c.cw5.zad2;

public class Water extends Liquid {

    protected boolean distilated = false;

    public Water(String name, int baseReagent, int dissolubility, boolean distilated) {
        super(name, baseReagent, dissolubility);
        setDistilated(distilated);
    }

    public boolean isDistilated() {
        return distilated;
    }

    public void setDistilated(boolean distilated) {
        this.distilated = distilated;
    }

    public int getReagent(){
        if(isDistilated()) {
            return super.getReagent();
        } else {
            return (super.getReagent() / 2);
        }
    }

}
