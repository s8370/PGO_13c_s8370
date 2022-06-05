package g13c.cw5.zad2;

public class Liquid extends Ingredient {

    protected int dissolubility = 100;

    public Liquid(String name, int baseReagent) {
        setName(name);
        setBaseReagent(baseReagent);
    }

    public Liquid(String name, int baseReagent, int dissolubility) {
        setName(name);
        setBaseReagent(baseReagent);
        setDissolubility(dissolubility);
    }

    public int getDissolubility() {
        return dissolubility;
    }

    public void setDissolubility(int dissolubility) {
        if(dissolubility >= 0 && dissolubility <= 100) {
            this.dissolubility = dissolubility;
        } else {
            throw new RuntimeException("Ilość musi być z przedziału od 0 do 100 (PROCENT)");
        }
    }

    public int getReagent(){
        return (int) (super.getReagent()*getDissolubility()*0.01);
    }

    public void print(){
        System.out.println(this.getName()+" (reagent: "+this.getReagent()+
                ", rozpuszczalnosć: "+this.getDissolubility()+")");
    }
}