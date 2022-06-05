package g13c.cw5.zad2;

public abstract class Ingredient {
    protected String name;
    protected int baseReagent = 0;

    public abstract void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new RuntimeException("Nazwa nie może być pusta");
        } else {
            this.name = name;
        }
    }

    public void setBaseReagent(int baseReagent) {
        if(baseReagent >= 0) {
            this.baseReagent = baseReagent;
        } else {
            throw new RuntimeException("Wartośc baseReagent musi być większa lub równa zero");
        }
    }
    protected int getReagent(){
        return baseReagent;
    }
}
