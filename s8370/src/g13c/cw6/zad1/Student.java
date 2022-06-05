package g13c.cw6.zad1;

import java.time.LocalDate;

public class Student extends Person {
    double scholarship = 0;

    public Student(String name, String surname, LocalDate dateOfBirth, double scholarship) {
        super(name, surname, dateOfBirth);
        this.scholarship = scholarship;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        if(scholarship >= 0) {
            this.scholarship = scholarship;
        } else {
            throw new RuntimeException("Stypendium nie może być mniejsze od 0");
        }
    }


    @Override
    double getIncome() {
        return getScholarship();
    }
}
