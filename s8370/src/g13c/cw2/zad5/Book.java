package g13c.cw2.zad5;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Book {

    private final Long ID = System.currentTimeMillis()|System.nanoTime(); // Unikalny identyfikator
    private String name; // Nazwa
    private Genre genre; // Gatunek
    private Lang language; // Język
    private LocalDate publishDate; // 0...1 (opcjonalne, 1 wartosc)
    private LocalDate createdDate = LocalDate.now(); // Auto (domyślnie)
    private int numberOfPages; // 0...1 (opcjonalne, 1 wartosc)
    private int borrowCount = 0; // Ilość wypożyczeń
    private final List<Person> authors = new ArrayList<>(); // Lista autorów
    private Person borrowedByPerson; // Kto pożyczył

    private final static List<Book> listBooks = new ArrayList<>();

    public Book(String name, Genre genre, Lang language){
        setName(name);
        setGenre(genre);
        setLanguage(language);
        listBooks.add(this);
    }
    public Book(String name, Genre genre, Lang language, List<Person> authors){
        setName(name);
        setGenre(genre);
        setLanguage(language);
        listBooks.add(this);
        if(authors.size() == 0){
            throw new RuntimeException("Książka musi mieć conajmniej jednego autora");
        } else {
            for (Person author : authors) {
                setAuthor(author);
            }
        }
    }

    public Book(String name, Genre genre, Lang language, List<Person> authors, LocalDate publishDate){
        this(name, genre, language, authors);
        setPublishDate(publishDate);
    }

    public Book(String name, Genre genre, Lang language, List<Person> authors, LocalDate publishDate, int numberOfPages){
        this(name, genre, language, authors, publishDate);
        setNumberOfPages(numberOfPages);
    }

    public Book(String name, Genre genre, Lang language, List<Person> authors, LocalDate publishDate, int numberOfPages, LocalDate createdDate){
        this(name, genre, language, authors, publishDate, numberOfPages);
        setCreatedDate(createdDate);
    }

    public Book(String name, Genre genre, Lang language, LocalDate publishDate){
        this(name, genre, language);
        setPublishDate(publishDate);
    }

    public Book(String name, Genre genre, Lang language, LocalDate publishDate, int numberOfPages){
        this(name, genre, language, publishDate);
        setNumberOfPages(numberOfPages);
    }

    public Book(String name, Genre genre, Lang language, LocalDate publishDate, int numberOfPages, LocalDate createdDate){
        this(name, genre, language, publishDate, numberOfPages);
        setCreatedDate(createdDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", language=" + language +
                ", publishDate=" + publishDate +
                ", createdDate=" + createdDate + "\n"+
                "       numberOfPages=" + numberOfPages +
                ", borrowCount=" + borrowCount +
                ", Age=" + getAge() +
                ", Wypożyczenia=" + getBorrowInfo()+
                ", isAvailable=" + isAvailable() + "\n"+
                "      authors=" + Person.toStringSelected(authors)+
                '}';
    }

    public static String toStringAll(){
        return toStringSelected(listBooks);
    }

    public static String toStringSelected(List<Book> listBooks){
        StringBuilder resText = new StringBuilder();
        if(listBooks.size() > 0) {
            int counter  = 1;
            for (Book listBook : listBooks) {
                resText.append("[").append(counter).append("] ").append(listBook.toString()).append("\n");
                counter++;
            }
        } else {
            resText = new StringBuilder("Nie znaleziono książek\n");
        }
        return resText.toString();
    }

    // WYLICZALNE: ILOSC LAT W BIBLIOTECE
    public int getAge(){
        if(this.publishDate != null) {
            return Period.between(this.publishDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    // ID
    public Long getID() {
        return ID;
    }

    // NAME
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

    // GENRE
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // LANGUAGE
    public Lang getLanguage() {
        return language;
    }
    public void setLanguage(Lang language) {
        this.language = language;
    }

    // PUBLISH DATE
    public LocalDate getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    // CREATED DATE
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    private void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    // NUMBER OF PAGES
    public int getNumberOfPages() {
        return numberOfPages;
    }
    private void setNumberOfPages(int numberOfPages) {
        if(numberOfPages < 0) {
            throw new RuntimeException("Wartość numberOfPages nie może być mniejsza od zera");
        } else {
            this.numberOfPages = numberOfPages;
        }
    }

    // BORROW COUNT
    public int getBorrowCount() {
        return borrowCount;
    }
    private void addBorrowCount() {
        this.borrowCount++;
    }
    public String getBorrowInfo(){
        String resText;
        int borrowCount = getBorrowCount();
        if(borrowCount == 1){
            resText = borrowCount+" raz";
        } else if(borrowCount > 0){
            resText = borrowCount+" razy";
        } else {
            resText = "Nigdy nie wypożyczono";
        }
        if(borrowedByPerson != null) {
            resText += " [W posiadaniu: "+borrowedByPerson.toStringSimply()+"]";
        }
        return resText;
    }
    public boolean isAvailable(){
        return this.borrowedByPerson == null;
    }

    // INSERT AUTHOR
    public void setAuthor(Person author) {
        this.authors.add(author);
    }

    // PLACE BACK
    public void PlaceBack(){
        if(borrowedByPerson != null){
            borrowedByPerson.setBorrowedBook(0);
            borrowedByPerson = null;
        }
    }

    // BORROW BOOK
    public void BorrowBook(Person borrowedBy){
        if(borrowedByPerson == null){
            if(borrowedBy.getBorrowedBook() == 0) {
                borrowedByPerson = borrowedBy;
                borrowedBy.setBorrowedBook(1);
                addBorrowCount();
            } else {
                throw new RuntimeException("Jedna osoba może wypożyczyć 1 książkę na raz");
            }
        } else {
            throw new RuntimeException("Książka nie jest w tej chwili dostępna");
        }
    }

    // FIND BOOK BY GENRE
    public static void FindBookByGenre(Genre genre){
        List<Book> resultBooks = new ArrayList<>();
        Iterator<Book> booksIterator = listBooks.iterator();
        Book bookElm;
        while (booksIterator.hasNext()) {
            bookElm = booksIterator.next();
            if(bookElm.getGenre().equals(genre)) {
                resultBooks.add(bookElm);
            }
        }
        System.out.println("Wyniki wyszukiwania dla: "+genre+":");
        if(resultBooks.size() > 0) {
            System.out.println(toStringSelected(resultBooks));
        } else {
            System.out.println("Nie znaleziono");
        }
    }
}
