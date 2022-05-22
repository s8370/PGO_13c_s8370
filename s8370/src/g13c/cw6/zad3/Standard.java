package g13c.cw6.zad3;

public class Standard extends Contract {

    protected int tax = 0;

    public Standard(Worker worker, Firm firm, double salary, int tax) {
        super(worker, firm, salary);
        setTax(tax);
    }

    public int getTax() {
        return tax;
    }

    protected void setTax(int tax) {
        if(tax < 0){
            throw new RuntimeException("Wartość TAX nie może być mniejsza od 0");
        } else if(tax > 100){
            throw new RuntimeException("Wartość TAX nie może być większa od 100");
        } else {
            this.tax = tax;
        }
    }

    public double getNetto(){
        return getBrutto() - (getBrutto() * getTax() * 0.01);
    }

    public String getContractInfo(){
        return "Contract{" +
                "worker=" + getWorker() +
                ", salary=" + getSalary() +
                ", tax=" + getTax() +"%"+
                '}';
    }

}