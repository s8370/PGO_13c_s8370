package g13c.cw2.zad5;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class zad5 {

    public static void main(String[] args) {

        /*
            DANE TESTOWE
         */

        Person p1 = new Person("Stephen", "King", LocalDate.parse("1947-09-21"),
                new Address("USA", "Portland", "Alberta", 1255, 12));
        Person p2 = new Person("Frank", "Herbert", LocalDate.parse("1920-10-08"), LocalDate.parse("1986-02-11"),
                new Address("USA", "Madison", "Mineral Point", 183));
        Person p3 = new Person("Jan", "Kowalski", LocalDate.parse("2001-05-23"),
                new Address("Polska", "Warszawa", "Puławska", 34, 7));
        Person p4 = new Person("Anna", "Nowak", LocalDate.parse("1994-04-11"),
                new Address("Polska", "Kraków", "Zwycistwa", 74, 124));
        Person p5 = new Person("Al", "Ewing", LocalDate.parse("1977-08-12"),
                new Address("United Kingdom", "London", "New North", 6));
        Person p6 = new Person("Mario", "Puzo", LocalDate.parse("1920-10-15"), LocalDate.parse("1999-07-02"),
                new Address("USA", "New York", "Central Road", 3));

        Book b1 = new Book("Shining", Genre.Classic, Lang.English, new ArrayList() {{ add(p1);}}, LocalDate.parse("1977-11-04"), 245, LocalDate.parse("2015-05-01"));
        Book b2 = new Book("Diuna", Genre.Fantasy, Lang.English, new ArrayList() {{ add(p1);}});
        Book b3 = new Book("Guardians of the Galaxy", Genre.Comics, Lang.Japanese, new ArrayList() {{ add(p3); add(p5);}}, LocalDate.parse("2008-04-15"), 56);

        // WYPISANIE WSTĘPNE DANYCH
        System.out.println("###### Lista książek w bibliotece: ######\n");
        System.out.println(Book.toStringAll());
        System.out.println("###### Lista osób: ######\n");
        System.out.println(Person.toStringAll());

        // WYPOŻYCZENIA KSIĄŻEK
        b1.BorrowBook(p4);
        b2.BorrowBook(p3);
        b2.PlaceBack();
        b2.BorrowBook(p5);
        b2.PlaceBack();
        b1.PlaceBack();
        b1.BorrowBook(p5);
        b2.BorrowBook(p2);
        b2.PlaceBack();

        // PUBLIKACJA NOWEJ KSIĄŻKI
        Book b4 = new Book("Godfather", Genre.Classic, Lang.English, LocalDate.parse("1969-05-17"), 348);
        p6.PublishBook(b4);

        // WYPOŻYCZENIA KSIĄŻEK C.D.
        b4.BorrowBook(p2);
        b2.BorrowBook(p4);
        b2.PlaceBack();

        // AKTUALNE KSIĄŻKI
        System.out.println("###### Aktualna lista książek w bibliotece: ######\n");
        System.out.println(Book.toStringAll());

        // WYSZUKIWANIE PO GATUNKU
        System.out.println("###### WYSZUKIWANIE PO GATUNKU: ######\n");
        Book.FindBookByGenre(Genre.Classic);

    }

}