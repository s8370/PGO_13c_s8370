package g13c.cw1.zad1;
import java.util.Scanner;

public class zad1 {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj a:");
    int a = scanner.nextInt();
    System.out.println("Podaj b:");
    int b = scanner.nextInt();
    System.out.println("Podaj c:");
    int c = scanner.nextInt();
    if(a <= b && a<= c){
        System.out.println("a: "+a);
        if(b <= c) System.out.println("b: "+b);
        else System.out.println("c: "+c);
    } else {
        System.out.println("reszta...");
    }
}
