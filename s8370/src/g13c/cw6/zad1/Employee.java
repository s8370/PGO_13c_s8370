package g13c.cw6.zad1;

import java.time.LocalDate;

public class Employee extends Person {
    double salary = 0;

    public Employee(String name, String surname, LocalDate dateOfBirth, double salary) {
        super(name, surname, dateOfBirth);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary > 0) {
            this.salary = salary;
        } else {
            throw new RuntimeException("Wynagrodzenie musi być większe od 0");
        }
    }

    @Override
    double getIncome() {
        return (getSalary() * 0.8);
    }
}
