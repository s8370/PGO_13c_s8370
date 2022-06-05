package g13c.cw6.zad1;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    String name, surname;
    LocalDate dateOfBirth;

    public Person(String name, String surname, LocalDate dateOfBirth) {
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
    }

    // Metoda abstrakcyjna, wiemy że będzie ale sposób liczenia nie jest znany na poziomie Person
    abstract double getIncome();

    // Metoda obiektowa z ciałem, każdy człowiek ma datę urodzenia i liczy się tak samo wiec można zdefiniować
    int getAgeInYears(){
        if(dateOfBirth != null){
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        } else {
            return 0;
        }
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
        }  else {
            this.dateOfBirth = dateOfBirth;
        }
    }

}
