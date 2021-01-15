package andreea.tema4ATM;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String IBAN;
    private int balance=0;
    private List <Card> cards = new ArrayList<>();

    public BankAccount(String IBAN, int initialSumDeposit, int numberOfCards) {
        this.IBAN = IBAN;
        balance=balance+initialSumDeposit;
    }

    public String getIBAN() {
        return IBAN;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void addCard(Card c){
        this.cards.add(c);
        c.setParent(this);
    }

}
