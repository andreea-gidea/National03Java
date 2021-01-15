package andreea.tema4ATM;

import sun.swing.BakedArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;


public class Card {
    private final String cardNumber;
    private final LocalDateTime expirationDate;
    private String cardPin;
    private BankAccount parent;

    public String getCardPin() {
        return cardPin;
    }

    public Card(String cardNumber, LocalDateTime expirationDate, String cardPin)  {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;

        if (cardPin.length()==4 &&(cardPin.replaceAll("[^0-9]+-", "")).length()==cardPin.length() ){
            this.cardPin=cardPin;
        }
        else {
            Random rand = new Random();
            Integer pin = rand.nextInt((9999 - 100) + 1) + 10;
            this.cardPin=pin.toString();
            System.out.println("Invalid pin number. your pin has been set to "+pin);
            pin=null;

        }

    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public BankAccount getParent() {
        return parent;
    }

    public void setParent(BankAccount parent) {
        this.parent = parent;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
