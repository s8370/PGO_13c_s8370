package g13c.cw5.zad2;

public class Crystal extends Mineral {

    protected int magicPower = 0;

    public Crystal(String name, int baseReagent, int magicPower) {
        super(name, baseReagent);
        setMagicPower(magicPower);
    }

    public Crystal(String name, int baseReagent, int power, int magicPower) {
        super(name, baseReagent, power);
        setMagicPower(magicPower);
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        if(magicPower >= 0) {
            this.magicPower = magicPower;
        } else {
            throw new RuntimeException("Magiczna moc nie może być mniejsza niż 0");
        }
    }

    public int getReagent(){
        return (super.getReagent() + getMagicPower());
    }
}
