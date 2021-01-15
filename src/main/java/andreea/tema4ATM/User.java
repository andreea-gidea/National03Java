package andreea.tema4ATM;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List <BankAccount> bankAccounts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBankAccount (BankAccount b){

        this.bankAccounts.add(b);
        System.out.println("New bank account added, bank account with IBAN" + b.getIBAN());

    }
}
