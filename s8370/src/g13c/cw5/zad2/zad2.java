package g13c.cw5.zad2;

public class zad2 {
    public static void main(String[] args) {

        // Dostępne składniki
        Water w1 = new Water("Woda destylowana", 10, 65, true);
        Water w2 = new Water("Woda zwykła", 30,  50, false);
        Alcohol a1 = new Alcohol("Wódka czysta", 170, 90, 65);
        Alcohol a2 = new Alcohol("Jin", 150, 77, 40);
        Ore o1 = new Ore("Platyna", 45, 165, false);
        Ore o2 = new Ore("Srebro", 15, 70, true);
        Crystal c1 = new Crystal("Cytryn", 215, 23, 99);
        Crystal c2 = new Crystal("Kalcyt", 45,67, 111);
        Crystal c3 = new Crystal("Selenit", 33, 1);
        Flower f1 = new Flower("Płatki róży", 15, 1);
        Flower f2 = new Flower("Kalatea", 10, 4);
        Plant p1 = new Plant("Wilcza jagoda", 5, 20);
        Plant p2 = new Plant("Tojad mocny", 11, 4);
        Plant p3 = new Plant("Złotokap zwyczajny", 7, 17);
        Root r1 = new Root("Maniok", 4, 15);

        // Eliksir 1 (NIE GOTOWY)
        Eliksir e1 = new Eliksir("Super-Strong");
        e1.setCatalyst(a1);
        e1.addIngredient(a2);
        e1.addIngredient(w1);
        e1.addIngredient(o1);
        e1.addIngredient(o2);
        e1.addIngredient(c3);
        e1.addIngredient(p2);
        e1.removeIngredient(w1);
        e1.addIngredient(f1);
        e1.addIngredient(c2);
        e1.addIngredient(r1);
        e1.removeIngredient(o2);
        e1.print();

        System.out.println("\n#######################\n");

        // Eliksir 2 (GOTOWY)
        Eliksir e2 = new Eliksir("Fast&Furious");
        e2.setCatalyst(a2);
        e2.addIngredient(w2);
        e2.addIngredient(c2);
        e2.addIngredient(o1);
        e2.addIngredient(o2);
        e2.addIngredient(f2);
        e2.addIngredient(p1);
        e2.removeIngredient(o1);
        e2.addIngredient(p3);
        e2.addIngredient(c1);
        e2.Create();
        e2.print();

    }
}
