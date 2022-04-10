package g13c.cw3.zad2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private double moneyInCash;
    private double moneyOnCard;
    private ShoppingCart currentCart;
    private final List<ShoppingCart> archiveCarts = new ArrayList<>();

    public Person(String name, String surname, double moneyInCash, double moneyOnCard) {
        setName(name);
        setSurname(surname);
        setMoneyInCash(moneyInCash);
        setMoneyOnCard(moneyOnCard);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new RuntimeException("Imię nie może być puste");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname == null || surname.isEmpty()){
            throw new RuntimeException("Nazwisko nie może być puste");
        }
        this.surname = surname;
    }

    public double getMoneyInCash() {
        return moneyInCash;
    }

    public void setMoneyInCash(double moneyInCash) {
        if(moneyInCash < 0){
            throw new RuntimeException("Wartość gotówki nie może wyjść poniżej zera");
        }
        this.moneyInCash = moneyInCash;
    }

    public double getMoneyOnCard() {
        return moneyOnCard;
    }

    public void setMoneyOnCard(double moneyOnCard) {
        if(moneyOnCard < 0){
            throw new RuntimeException("Wartość na karcie nie może wyjść poniżej zera");
        }
        this.moneyOnCard = moneyOnCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", moneyInCash=" + getMoneyInCash() +
                ", moneyOnCard=" + getMoneyOnCard() +
                ", currentCart=" + currentCart +
                ", archiveCarts=" + archiveCarts +
                '}';
    }

    public ShoppingCart MakeOrder(){
        if(currentCart != null){
            makeCartArchive();
        }
        currentCart = new ShoppingCart();
        return currentCart;
    }

    public void BuyByCard(){
        if(currentCart == null){
            throw new RuntimeException("Nie ma koszyka do zakupu");
        }
        if(getMoneyOnCard() <= currentCart.getTotalPrice()){
            throw new RuntimeException("Brak wystarczajaco wystarczającej pieniędzy na karcie");
        }
        currentCart.Sell();
        setMoneyOnCard(getMoneyOnCard() - currentCart.getTotalPrice());
        makeCartArchive();
    }

    public void BuyInCash(){
        if(currentCart == null){
            throw new RuntimeException("Nie ma koszyka do zakupu");
        }
        if(getMoneyInCash() <= currentCart.getTotalPrice()){
            throw new RuntimeException("Brak wystarczajaco wystarczającej gotówki");
        }
        currentCart.Sell();
        setMoneyInCash(getMoneyInCash() - currentCart.getTotalPrice());
        makeCartArchive();
    }

    private void makeCartArchive(){
        archiveCarts.add(currentCart);
        currentCart = null;
    }
}
