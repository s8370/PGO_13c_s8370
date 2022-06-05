package g13c.cw6.zad3;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final DecimalFormat df = new DecimalFormat("0.0");

    public static void main(String[] args) {

        List<Function> functions = new ArrayList<>();

        functions.add(new LinearFunction(2,4));
        functions.add(new SquareFunction(2,0,-2.5));
        functions.add(new AbsoluteLinearFunction(2,4));

        List<Fun> funList = new ArrayList<>(functions);

        System.out.println("Original functions");
        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));

        functions.forEach(f -> f.increaseCoefficientsBy(1.2));

        System.out.println("Functions increased by 1.2");

        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));

        functions.forEach(f -> f.decreaseCoefficientsBy(1.2));
        System.out.println("Functions decreased by 1.2");
        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));

        /*
            -- ZADANIE DODATKOWE
            # FUNKCJA NR 1:
            Wyszukiwanie minimalnej wartości dla wartości wyliczanych przez przekazaną bezpośrdnio funkcję wewnętrzną
            która przelicza wskazaną wartość przez algorytm który jest inny w zależności czy zmienna jest parzysta czy nie, a
            wartość zwracana jest wartością bezwzględną.
            # FUNKCJA NR 2:
            Funkcja kwadratowa której wynikową wartość dla wskazanego przedziału zwraca wartość minimalną
        */
        /*
        // FUNKCJA NR 1
        double min = Fun.minimum(x ->
            { if(x%2==0) return Math.abs(x*5-x*1.5); else return Math.abs(x*2-x*1.2); }, 4,10,1.5);
        System.out.println("Fun1: "+min);
         */

        // FUNKCJA NR 2
        // System.out.println("Fun2: "+Fun.minimum(x -> (-1*x*x+5*x+1), 0,99,1));

    }
}
