package g13c.cw7.zad3;

public class Child extends Character {
    public Child(String name, Location location) throws StoryViolationException {
        setName(name);
        setLocation(location);
        setType(2);
    }
}
