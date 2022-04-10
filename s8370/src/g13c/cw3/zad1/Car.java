package g13c.cw3.zad1;

public class Car {
    private int weight;
    private Car nextCar;

    public Car(int weight) {
        setWeight(weight);
    }

    public Car getNextCar(){
        return nextCar;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setNextCar(Car car){
        this.nextCar = car;
    }

    @Override
    public String toString() {
        return "Car{" +
                "weight=" + weight +
                ", nextCar=" + nextCar +
                '}';
    }
}
