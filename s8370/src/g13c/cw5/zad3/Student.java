package g13c.cw5.zad3;

import java.time.LocalDate;

public class Student extends Person {

    protected double scholarship = 0;

    public Student(String name, String surname, LocalDate dateOfBirth, double scholarship) {
        super(name, surname, dateOfBirth);
        setScholarship(scholarship);
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        if(scholarship < 0){
            throw new RuntimeException("Wartość scholarship nie może być mniejsza od zera");
        } else {
            this.scholarship = scholarship;
        }
    }

    public double getIncome(){
        return scholarship;
    };

}
