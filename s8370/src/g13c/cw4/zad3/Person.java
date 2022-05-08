package g13c.cw4.zad3;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person {
    protected String name;
    protected String surname;
    protected LocalDate dateOfBirth;
    protected final static List<Person> personList = new ArrayList<>(); // Lista autorów

    public Person(String name, String surname, LocalDate dateOfBirth) {
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        personList.add(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", (" + getAge() + " lat)"+
                ", income: " + getIncome() +
                '}';
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new RuntimeException("Wartość name nie może być pusta");
        } else {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    protected void setSurname(String surname) {
        if(surname == null || surname.isEmpty()){
            throw new RuntimeException("Wartość surname nie może być pusta");
        } else {
            this.surname = surname;
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    protected void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth == null){
            throw new RuntimeException("Wartość dateOfBirth nie może być pusta");
        } else if(getAge(dateOfBirth) < 16){
            throw new RuntimeException("Osoba musi mieć skończone przynajmniej 16 lat");
        }  else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public int getAge(){
        if(this.dateOfBirth != null) {
            return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public int getAge(LocalDate dob){
        if(dob != null){
            return Period.between(dob, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public double getIncome(){
        return 0;
    };
    protected void printInfoInternal(){
        System.out.print(getName()+" "+getSurname()+", Lat: "+getAge()+", Dochód: "+getIncome());
    }

    public void printInfo(){
        printInfoInternal();
        System.out.println();
    };

    public static Person getOlder(Person a, Person b){
        int ageA = a.getAge();
        int ageB = b.getAge();
        if(ageA >= ageB){
            return a;
        } else {
            return b;
        }
    }

    public static String printAllInfo(){
        StringBuilder resText = new StringBuilder();
        if(personList.size() > 0) {
            for (Person p : personList) {
                p.printInfo();
            }
        } else {
            resText = new StringBuilder("Nie znaleziono żadnych osób\n");
        }
        return resText.toString();
    }

}
