package g13c.cw5.zad2;

public class Plant extends Ingredient {
    protected int toxity = 0;

    public Plant(String name, int baseReagent) {
        super(name, baseReagent);
    }

    public Plant(String name, int baseReagent, int toxity) {
        super(name, baseReagent);
        setToxity(toxity);
    }

    public int getToxity() {
        return toxity;
    }

    public void setToxity(int toxity) {
        if(toxity >= 0) {
            this.toxity = toxity;
        } else {
            throw new RuntimeException("Toksyczność nie może być mniejsza od 0");
        }
    }

    public int getReagent(){
        if(getToxity() > 0) {
            return (super.getReagent() * getToxity());
        } else {
            return super.getReagent();
        }
    }

    public void print(){
        System.out.println(this.getName()+" (reagent: "+this.getReagent()+
                ", toksyczność: "+this.getToxity()+")");
    }
}
