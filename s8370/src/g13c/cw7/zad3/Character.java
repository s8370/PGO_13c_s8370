package g13c.cw7.zad3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Character {

    protected int health = 100;
    protected String name;
    protected Location location;
    protected int type = 0;
    protected static final List<Character> characters = new ArrayList<>();
    protected static final List<Character> targetlist = new ArrayList<>();

    public static void status() {
        System.out.println("====Status====");
        List<String> states = new ArrayList<>();
        characters.sort(Comparator.comparing(Character::getType));
        for (Character character : characters) {
            states.add(status(character));
        }
        for (String state : states) {
            System.out.println(state);
        }
        System.out.println("==============");
    }
    public static String status(Character a){
        return a.getName()+" : "+a.getHealth();
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(health < 0 || health > 100){
            throw new RuntimeException("Zdrowie musi być między 0 a 100");
        } else {
            this.health = health;
        }
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new RuntimeException("Imię nie może być puste");
        } else {
            this.name = name;
        }
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) throws StoryViolationException {
        if(location == null ) {
            throw new StoryViolationException("Lokalizacja nie może być pusta");
        } else {
            this.location = location;
        }
    }
    public static void MoveAllTo(Location l, Character a, Character b) throws StoryViolationException{
        a.setLocation(l);
        b.setLocation(l);
    }
    public void addChild(Character a) throws StoryViolationException {
        a.setLocation(this.getLocation());
    }
    public void moveTo(Character woolsOrphanage) throws StoryViolationException{
        setLocation(woolsOrphanage.getLocation());
    }
    public void moveTo(Location location) throws StoryViolationException {
        this.setLocation(location);
    }

    public void introduce(){
        System.out.println("Hello, I am "+getName());
    }
    public void say(String msg, Character b){
        System.out.println(this.getName()+" to "+b.getName()+"\n" +
                "\t"+msg);
    }
    public void doSth(String msg){
        System.out.println("I am "+getName()+", I am "+msg);
    }
    public static void doSth(String msg, Character a, Character b, Child c) {
        a.doSth(msg);
        b.doSth(msg);
        c.doSth(msg);
    }

    public void target(Character c){
        targetlist.add(c);
    }
    public static void castSpell(Spell spell, Character c){
        int reduceHealth = 0;
        if (spell == Spell.AvadaKedavra) {
            if (!c.getName().equals("Harry")) {
                reduceHealth = 100;
            }
        }
        c.setHealth(Math.max(c.getHealth() - reduceHealth, 0));
    }
    public void castSpell(Spell spell){
        for (Character character : targetlist) {
            castSpell(spell, character);
            if(character.getHealth() > 0){
                System.out.println(character.getName()+" goes LOL...");
            } else {
                System.out.println(character.getName()+" died.");
            }
        }
    }
}
