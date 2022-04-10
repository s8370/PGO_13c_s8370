package g13c.cw3.zad2;

public class zad2 {
    public static void main(String[] args) {

        Storage sLocal = new Storage(2);
        Storage sWorld = new Storage(4);

        Person p1 = new Person("Jan", "Kowalski", 5000, 20000);

        Product cat1 = new Product("Black Caviour", ProductType.Consumable, 800, 0, sLocal);
        Product cat2 = new Product("Govt Mule Music Album", ProductType.Entertainment, 10, 900);
        Product cat3 = new Product("MacBook Pro", ProductType.Electronic, 1500, 1, sWorld);
        Product cat4 = new Product("TV LG OLED 55", ProductType.Electronic, 2600, 3, sLocal);
        cat1.IncreaseQuantity(4);
        Product.toStringAll();

        System.out.println("--------- EMPTY PERSON ---------");
        System.out.println(p1);

        System.out.println("--------- CURRENT ORDER (TRY ALL) ---------");
        ShoppingCart cart1 = p1.MakeOrder();
        if(cat1.isAvailable()) cart1.insertProduct(cat1);
        if(cat2.isAvailable()) cart1.insertProduct(cat2);
        if(cat3.isAvailable())  cart1.insertProduct(cat3);
        if(cat4.isAvailable())  cart1.insertProduct(cat4);
        //cart1.insertProduct(cat4); // Próba dodania produktu którego nie ma na stanie magazynowym

        // Dodanie większej ilości tego samego produktu
        if(cat1.isAvailable())  cart1.insertProduct(cat1); // ... 2 szt.
        if(cat1.isAvailable())  cart1.insertProduct(cat1); // ... 3 szt.
        if(cat1.isAvailable())  cart1.insertProduct(cat1); // ... 4 szt.
        //if(cat1.isAvailable())  cart1.insertProduct(cat1); // ... 5 szt. (Więcej niż 4 zadeklrowane wcześniej!)
        System.out.println(p1);

        System.out.println("--------- PAID FOR ORDER ---------");

        System.out.println("Czas dostarczenia zamówienia: "+cart1.getTotaDeliveryTime());

        // p1.BuyInCash(); // Próba zapła ty gotówką
        if(cart1.getTotalPrice() <= p1.getMoneyInCash()){
            // Próba zapłaty gotó∑ki
            System.out.println("Wystarczające zasoby na zapłątę gotówką");
            p1.BuyInCash();
        } else if(cart1.getTotalPrice() <= p1.getMoneyOnCard()){
            // W innej sytuacji spróbuj zapłacić kartą
            p1.BuyByCard();
        }

        System.out.println("--------- ENDED ORDER ---------");
        System.out.println(p1);
        System.out.println("--------- PRODUCTS AFTER ORDERING ---------");
        Product.toStringAll();


        System.out.println("--------- NEW CART ---------");
        ShoppingCart cart2 = p1.MakeOrder();
        cart2.insertProduct(cat2);
        System.out.println(cart2);
    }
}
