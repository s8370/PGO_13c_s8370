package g13c.cw3.zad2;

public class Storage {
    private int deliveryTime = 1;

    public Storage(int deliveryTime) {
        setDeliveryTime(deliveryTime);
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        if(deliveryTime <= 0){
            throw new RuntimeException("Czas dostawy dla produktu magazynowego musi być większe od 0");
        }
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "deliveryTime=" + getDeliveryTime() +
                '}';
    }
}
