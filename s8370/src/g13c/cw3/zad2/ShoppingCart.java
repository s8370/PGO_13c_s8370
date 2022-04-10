package g13c.cw3.zad2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private int id = 0;
    private final List<Product> products = new ArrayList<>();
    private static int maxId = 0;

    public ShoppingCart() {
        setId();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = maxId+1;
        maxId++;
    }

    public void Sell(){
        if(products.size() ==0){
            throw new RuntimeException("Koszyk nie zawiera produktów");
        }
        cartSumAvailablityValidation();
        for(Product product : products){
            product.Sell();
        }
    }

    /*
        Metoda walidująca czy ilość wszystkich produktów w koszyku pokrywa się ze stanami magazynowi
        Na potrzeby weryfikacji tuż przed złożeniem zamówienia.
     */
    public void cartSumAvailablityValidation(){
        int cartQuantity;
        Map<Product, Integer> cartProducts = new HashMap<>();
        // Zasumowanie produktów aby sprawdzić ich łączną dostępność na magazynie
        if(products.size() > 0) {
            for(Product product : products) {
                cartQuantity = 1;
                if(cartProducts.containsKey(product)){
                    cartQuantity += cartProducts.get(product);
                    cartProducts.remove(product);
                }
                cartProducts.putIfAbsent(product, cartQuantity);
            }
        }
        if(cartProducts.size() > 0){
            for(Map.Entry<Product, Integer> cartProduct : cartProducts.entrySet()){
                Product product = cartProduct.getKey();
                if(product.getQuantity() < cartProduct.getValue()){
                    throw new RuntimeException("Produktu "+product+" nie ma wystarczająco dużo na pokrycie zamówienia (Potrzeba: "+cartProduct.getValue()+" w koszyku o ID: "+getId()+")");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + getId() +
                ", products=" + products +
                ", totalPrice=" + getTotalPrice() +
                ", totalDeliveryTime=" + getTotaDeliveryTime() +
                '}';
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        if(products.size() > 0) {
            for (Product product : products) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public int getTotaDeliveryTime(){
        int totalDeliveryTime = 0;
        if(products.size() > 0) {
            for (Product product : products) {
                if(product.getDeliveryTime() > totalDeliveryTime){
                    totalDeliveryTime = product.getDeliveryTime();
                }
                //totalPrice += product.getPrice();
            }
        }
        return totalDeliveryTime;
    }

    public void insertProduct(Product product){
        if(product.getQuantity() <= 0){
            throw new RuntimeException("Produktu nie ma na stanie magazynowym");
        }
        products.add(product);
    }
}
