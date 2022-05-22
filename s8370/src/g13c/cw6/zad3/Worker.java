package g13c.cw6.zad3;

import java.time.LocalDate;

public class Worker extends Person {
    protected Contract contract;

    public Worker(String name, String surname, LocalDate dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    protected void setContract(Contract contract) {
        if(isContract() == false) {
            this.contract = contract;
        } else {
            throw new RuntimeException("Worker nie może mieć więcej niż jednej umowy");
        }
    }

    protected boolean isContract(){
        if(this.contract == null) {
            return false;
        } else {
            return true;
        }
    }

    public void printInfo(){
        printInfoInternal();
        if(isContract() == true) {
            System.out.println(", Pracownik firmy: "+contract.getFirmName());
        } else {
            System.out.println(", Pracownik firmy: !BRAK!");
        }
    };

    public double getIncome(){
        if(isContract() == true) {
            return this.contract.getNetto();
        } else {
            return 0;
        }
    };
}
