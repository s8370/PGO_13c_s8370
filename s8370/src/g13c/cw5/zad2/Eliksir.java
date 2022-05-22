package g13c.cw5.zad2;

import java.util.ArrayList;
import java.util.List;

public class Eliksir {

    private String name = "";
    private boolean isCreated = false;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private Liquid catalyst = null;
    private int power = 0;

    public Eliksir(String name) {
        setName(name);
    }

    public int getPower(){
        if(isCreated()){
            throw new RuntimeException("Nie dostępne dla utworzonych eliksirów");
        } else {
            return power;
        }
    }

    private void powerUpdate(){
        int power = 0;
        if(catalyst == null) {
            throw new RuntimeException("Brak katalizatora do wyliczenia mocy eliksiru");
        } else {
            if (ingredients.size() > 0) {
                for (Ingredient ingredient : ingredients) {
                    power += ingredient.getReagent();
                }
            }
            if(catalyst.getReagent() > 0){
                power = power / catalyst.getReagent();
            } else {
                power = 0;
            }
        }
        this.power = power;
    }

    public void print(){
        System.out.println("Eliksir: "+getName()+", składników: "+ingredients.size());
        for (Ingredient ingredient : ingredients) {
            System.out.print("- ");
            ingredient.print();
        }
        if(getCatalyst() == null){
            System.out.println("Uwaga: Brak katalizatora");
        } else {
            System.out.print("Katalizator: ");
            getCatalyst().print();
        }
        if(isCreated()){
            System.out.println("Eliksir został utworzony");
        } else {
            System.out.println("Uwaga: Eliksir nie utworzony, aktualna moc: "+getPower());
        }
    }

    public void addIngredient(Ingredient o){
        if(!isCreated){
            ingredients.add(o);
            this.powerUpdate();
        } else {
            throw new RuntimeException("Nie można dodać gdy Eliksir już istnieje");
        }
    }

    public void removeIngredient(Ingredient o){
        if(!isCreated){
            ingredients.remove(o);
            this.powerUpdate();
        } else {
            throw new RuntimeException("Nie można usunąć gdy Eliksir już istnieje");
        }
    }

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

    public boolean isCreated() {
        return isCreated;
    }

    public Liquid getCatalyst() {
        return catalyst;
    }

    public void setCatalyst(Liquid catalyst) {
        if(isCreated()){
            throw new RuntimeException("Nie można zmienić gdy już utworzono Eliksir");
        } else {
            this.catalyst = catalyst;
            powerUpdate();
        }
    }

    public void Create(){
        if(isCreated()) {
            throw new RuntimeException("Eliksir już jest utworzony (moc nie jest dostępa)");
        } else if(this.catalyst == null){
            throw new RuntimeException("Eliksir musi posiadać katalizator");
        } else {
            powerUpdate();
            this.isCreated = true;
        }
    }
}
