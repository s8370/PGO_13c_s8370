package g13c.cw3.zad1;

public class Train {
    private String name;
    private Car car;

    public Train(String name) {
        setName(name);
    }

    public Train(String name, Car car) {
        setName(name);
        setCar(car);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void removeCar(){
        this.car = null;
    }

    public void AddCar(int w){
        if(this.car == null){
            setCar(new Car(w));
            return;
        }
        Car current = car;
        while (current.getNextCar() != null) {
            current = current.getNextCar();
        }
        current.setNextCar(new Car(w));
    }

    public int getWeight(){
        if(this.car == null) {
            return 0;
        }
        int res = 0;
        Car current = car;
        while (current.getNextCar() != null) {
            res += current.getWeight();
            current = current.getNextCar();
        }
        res += current.getWeight();
        return res;
    }

    @Override
    public String toString() {
        return "Train{" +
                "name='" + name + '\'' +
                "weight='" + getWeight() + '\'' +
                ", car=" + car +
                '}';
    }
}
