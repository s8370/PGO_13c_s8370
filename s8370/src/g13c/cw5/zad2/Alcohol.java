package g13c.cw5.zad2;

public class Alcohol extends Liquid {

    protected int percent = 0;

    public Alcohol(String name, int baseReagent, int dissolubility, int percent) {
        super(name, baseReagent, dissolubility);
        setPercent(percent);
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        if(percent >= 0 && percent <= 100) {
            this.percent = percent;
        } else {
            throw new RuntimeException("Procent musi być z przedziału od 0 do 100");
        }
    }

    public int getReagent(){
        if(getPercent() > 0){
            return super.getReagent();
            //return (super.getReagent() * (1 - getPercent() / 100));
        } else {
            return super.getReagent();
        }
    }
}
