package g13c.cw7.zad3;

public class Potter extends Child {
    public Potter(String name, Location location) throws StoryViolationException {
        super(name, location);
        setType(1);
        if (name.equals("Harry")){ setType(3); }
        characters.add(this);
    }
}