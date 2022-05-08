package g13c.cw4.zad3;

public class Contract {
    protected Worker worker;
    protected Firm firm;
    protected double salary = 0;

    public Contract(Worker worker, Firm firm, double salary) {
        if(worker == null) {
            throw new RuntimeException("Worker jest wymagany");
        } else if(firm == null) {
            throw new RuntimeException("Firma jest wymagana");
        } else if(salary <= 0) {
            throw new RuntimeException("Wynagrodzenie musi być większe od 0");
        } else if(worker.isContract() == true) {
            throw new RuntimeException("Wybrany Worker ma już umowę");
        } else {
            setWorker(worker);
            setFirm(firm);
            setSalary(salary);
            firm.addContract(this);
            worker.setContract(this);
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                "worker=" + getWorker() +
                ", firm=" + getFirm() +
                ", salary=" + getSalary() +
                '}';
    }

    public String getContractInfo(){
        return "Contract{" +
                "worker=" + getWorker() +
                ", salary=" + getSalary() +
                '}';
    }

    public Worker getWorker() {
        return worker;
    }

    protected void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Firm getFirm() {
        return firm;
    }

    protected void setFirm(Firm firm) {
        this.firm = firm;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBrutto(){
        return salary;
    }

    public double getNetto(){
        return getBrutto();
    }

    public String getFirmName(){
        return firm.getName();
    }
}
