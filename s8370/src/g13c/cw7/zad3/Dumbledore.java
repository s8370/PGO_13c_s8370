package g13c.cw7.zad3;

public class Dumbledore extends Character {
    public Dumbledore(String name, Location location) throws StoryViolationException {
        setName(name);
        setLocation(location);
        setType(4);
        characters.add(this);
    }
}
