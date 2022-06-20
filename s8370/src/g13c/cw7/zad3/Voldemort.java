package g13c.cw7.zad3;
import java.util.ArrayList;
import java.util.List;

public class Voldemort extends Character {
    public Voldemort(Riddle a) throws StoryViolationException {
        setName(a.getName());
        setLocation(a.getLocation());
        setType(2);
        characters.add(this);
    }

    public String getName() {
        return "Lord Voldemort";
    }

    protected final List<String> horcruxes = new ArrayList<>();

    private void createHorcruxs(String name){
        if(name == null || name.isEmpty()) {
            throw new RuntimeException("Nazwa nie może być pusta");
        } else {
            horcruxes.add(name);
        }
    }

    public void createHorcruxes(int h){
        for(int a=1;a<=h;a++){
            createHorcruxs("horcrux "+(horcruxes.size()+1));
        }
        if(horcruxes.size() == 8) {
            this.setHealth(0);
            System.out.println("Lord Voldemort died.");
        }
    }

    public void printHorcruxes(){
        System.out.println("Created horcruxes:");
        for (String horcruxe : horcruxes) {
            System.out.println("\t"+horcruxe);
        }
    }
}
