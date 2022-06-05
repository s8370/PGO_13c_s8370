package g13c.cw6.zad3_stare;

import java.time.LocalDate;

public class zad3 {
    public static void main(String[] args) {
        // Pracownicy
        Worker w1 = new Worker("Jan", "Kowalski", LocalDate.parse("1989-10-08"));
        Worker w2 = new Worker("Anna", "Kowalska", LocalDate.parse("1988-04-22"));
        Worker w3 = new Worker("Katarzyna", "Nowak", LocalDate.parse("2000-07-16"));

        // Studenci
        Student s1 = new Student("Karolina", "Wiśniewska", LocalDate.parse("2000-02-13"), 600);
        Student s2 = new Student("Mateusz", "Król", LocalDate.parse("1989-07-06"), 350);
        Student s3 = new Student("Weronika", "Piotrowska", LocalDate.parse("1985-05-05"), 0);

        // Firmy
        Firm f1 = new Firm("DELL SA");
        Firm f2 = new Firm("Apple Co.");

        // Umowy pracowników
        Contract c1 = new Contract(w1, f1, 14000);
        Contract c2 = new Standard(w2, f1, 19600, 12);
        Contract c3 = new Contract(w3, f2, 15500);

        // Wypisz użytkowników
        System.out.println("########### OSOBY:");
        Person.printAllInfo();

        System.out.println();

        // Wypisz kontrakty poszczególnych firm
        System.out.println("########### FIRMY:");
        System.out.println(Firm.printAllContract());

        // Najstarszy pracownik firmy
        System.out.print("# NAJSTARSZY PRACOWNIK: ");
        System.out.println(Person.getOlder(w1,Person.getOlder(w2,w3)));

        System.out.print("# NAJSTARSZY STUDENT: ");
        System.out.println(Person.getOlder(s1,Person.getOlder(s2,s3)));

    }
}
