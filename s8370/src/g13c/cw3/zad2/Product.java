package g13c.cw3.zad2;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private ProductType ptype;
    private double price;
    private int quantity;
    private Storage storage;
    private static final List<Product> products = new ArrayList<>();

    public Product(String name, ProductType ptype, double price, int quantity) {
        setName(name);
        setProductType(ptype);
        setPrice(price);
        setQuantity(quantity);
        products.add(this);
    }

    public Product(String name, ProductType ptype, double price, int quantity, Storage storage){
        this(name, ptype, price, quantity);
        setStorage(storage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new RuntimeException("Nazwa nie może być pusta");
        }
        this.name = name;
    }

    public ProductType getProductType() {
        return ptype;
    }

    public void setProductType(ProductType ptype) {
        if(ptype == null) {
            throw new RuntimeException("Typ produktu nie może być pusty");
        }
        this.ptype = ptype;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new RuntimeException("Cena produktu musi być większa od zera");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new RuntimeException("Ilość nie może być mniejsza niż 0");
        }
        this.quantity = quantity;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage){
        this.storage = storage;
    }

    public int getDeliveryTime(){
        if(storage == null) {
            return 0;
        }
        return storage.getDeliveryTime();
    }

    public boolean isAvailable(){
        return quantity > 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + getName() + '\'' +
                ", ptype=" + getProductType() +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", storage=" + getStorage() +
                '}';
    }

    public static void toStringAll(){
        if(products.size() == 0){
            System.out.println("W sklepie nie ma produktów");
        }
        System.out.println("Produkty w sklepie:");
        for(Product product : products){
            System.out.println(product);
        }
    }

    public void Sell() {
        setQuantity(quantity-1);
    }

    public void IncreaseQuantity(int morequantity) {
        setQuantity(quantity + morequantity);
    }
}
