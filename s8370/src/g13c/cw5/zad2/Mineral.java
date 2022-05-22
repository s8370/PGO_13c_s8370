package g13c.cw5.zad2;

public class Mineral extends Ingredient {

    protected int power = 0;

    public Mineral(String name, int baseReagent) {
        super(name, baseReagent);
    }

    public Mineral(String name, int baseReagent, int power) {
        super(name, baseReagent);
        setPower(power);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if(power >= 0) {
            this.power = power;
        } else {
            throw new RuntimeException("Moc nie może być mniejsza niż 0");
        }
    }

    public int getReagent(){
        return (super.getReagent() + getPower());
    }

    public void print(){
        System.out.println(this.getName()+" (reagent: "+this.getReagent()+
                ", moc: "+this.getPower()+")");
    }
}
