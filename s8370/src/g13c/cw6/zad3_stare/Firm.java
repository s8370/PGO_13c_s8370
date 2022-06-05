package g13c.cw6.zad3_stare;

import java.util.ArrayList;
import java.util.List;

public class Firm {
    protected String name;
    protected final static List<Firm> firmList = new ArrayList<>(); // Lista umów
    protected List<Contract> contractList = new ArrayList<>(); // Lista umów

    public Firm(String name) {
        setName(name);
        firmList.add(this);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Wartość name nie może być pusta");
        } else {
            this.name = name;
        }
    }

    protected void addContract(Contract contract){
        contractList.add(contract);
    }

    @Override
    public String toString() {
        return "Firm{" +
                "name='" + name + '\'' +
                ", contractList=" + contractList +
                '}';
    }

    public static String printAllContract(){
        StringBuilder resText = new StringBuilder();
        if(firmList.size() > 0) {
            for (Firm f : firmList) {
                resText.append(f.getName());
                if(f.contractList.size() > 0) {
                    resText.append(" | Kontrakty: "+f.contractList.size()+"\n");
                    for (Contract c : f.contractList) {
                        resText.append("- "+c.getContractInfo()+"\n");
                    }
                } else {
                    resText.append(" | Kontrakty: BRAK\n");
                }
            }
        } else {
            resText = new StringBuilder("Nie znaleziono żadnych firm\n");
        }
        return resText.toString();
    }
}
