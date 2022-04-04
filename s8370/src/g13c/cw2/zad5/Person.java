package g13c.cw2.zad5;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private final Address address;
    private int borrowedBook = 0; // 0 = Nie wypożyczono, 1 = Wypożyczono

    private static final List<Person> listPersons = new ArrayList<>();

    public Person(String name, String surname, LocalDate dateOfBirth, Address address) {
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        this.address = address;
        listPersons.add(this);
    }

    public Person(String name, String surname, LocalDate dateOfBirth, LocalDate dateOfDeath, Address address) {
        this(name, surname, dateOfBirth, address);
        setDateOfDeath(dateOfDeath);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", Age =" + getAgeInfo() +
                ", Address=" + address +
                '}';
    }

    public String toStringSimply() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public static String toStringAll(){
        StringBuilder resText = new StringBuilder();
        if(listPersons.size() > 0) {
            int counter  = 1;
            for (Person listPerson : listPersons) {
                resText.append("[").append(counter).append("] ").append(listPerson.toString()).append("\n");
                counter++;
            }
        } else {
            resText = new StringBuilder("Brak ludzi");
        }
        return resText.toString();
    }

    public static String toStringSelected(List<Person> persons){
        StringBuilder resText = new StringBuilder();
        if(persons.size() > 0) {
            for (Person person : persons) {
                resText.append(person.toStringSimply()).append(", ");
            }
        } else {
            resText = new StringBuilder("Brak");
        }
        return resText.toString();
    }

    // Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.isEmpty() || name == null){
            throw new RuntimeException("Wartość name nie może być pusta");
        } else {
            this.name = name;
        }
    }
    // Surname
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        if(surname.isEmpty() || surname == null){
            throw new RuntimeException("Wartość surname nie może być pusta");
        } else {
            this.surname = surname;
        }
    }
    // Date Of Birth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth.equals(null)) {
            throw new RuntimeException("Data urodzenia nie może być pusta");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }
    // Date Of Death
    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }
    public void setDateOfDeath(LocalDate dateOfDeath) {
        if(dateOfDeath.equals(null)) {
            throw new RuntimeException("Data śmierci nie może być pusta");
        } else {
            this.dateOfDeath = dateOfDeath;
        }
    }
    // Czy wypożyczono
    public int getBorrowedBook() {
        return borrowedBook;
    }
    public void setBorrowedBook(int borrowedBook) {
        if(borrowedBook == 1 || borrowedBook == 0) {
            this.borrowedBook = borrowedBook;
        } else {
            throw new RuntimeException("Nieprawidłowa wartość dla borrowedBook");
        }
    }

    // Age
    public int getAge(){
        if(this.dateOfBirth != null) {
            if(this.dateOfDeath != null) {
                return Period.between(this.dateOfBirth, this.dateOfDeath).getYears();
            } else {
                return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
            }
        } else {
            return 0;
        }
    }
    public String getAgeInfo(){
        int myAge = getAge();
        if(myAge > 0){
            if(dateOfDeath == null){
                return myAge+" lat";
            } else {
                return myAge+" lat (zmarły)";
            }
        } else {
            return "Brak danych";
        }
    }

    // Publikacja książki
    public Book PublishBook(String name, Genre genre, Lang language, LocalDate publishDate){
        ArrayList<Person> authors = new ArrayList<Person>();
        authors.add(this);
        Book b = new Book(name, genre, language, authors);
        b.setPublishDate(publishDate);
        return b;
    }

    public Book PublishBook(String name, Genre genre, Lang language, LocalDate publishDate, int numberOfPages){
        ArrayList<Person> authors = new ArrayList<Person>();
        authors.add(this);
        Book b = new Book(name, genre, language, authors, publishDate);
        b.setNumberOfPages(numberOfPages);
        return b;
    }


}
