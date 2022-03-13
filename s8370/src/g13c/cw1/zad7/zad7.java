package g13c.cw1.zad7;

import java.util.Scanner;

public class zad7 {
    public static void main(String[] args) {
        rys();
    }

    public static void rys(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj n (wieksze od 4): ");
        int n = scanner.nextInt();
        while(true) {
            if(n < 5) {
                System.out.println("Podaj liczbe 5 lub wieksza");
                n = scanner.nextInt();
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(i == j || i == 0 || j == 0 || i+1 == n || j+1 == n) {
                            System.out.print("*");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("Utworzono widok dla n = "+n);
                break;
            }
        }
    }
}
