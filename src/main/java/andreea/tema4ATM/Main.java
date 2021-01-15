package andreea.tema4ATM;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        User userNumberOne = new User("Andreea Gidea");
        BankAccount bankAccOfUser1= new BankAccount("ROZBR124" , 123 , 1);
        Card cardOfUserNr1 = new Card("098255" , LocalDateTime.of(2021, Month.APRIL, 01,00,00
        ),"1234");
        bankAccOfUser1.addCard(cardOfUserNr1);

        System.out.println(bankAccOfUser1);

        System.out.println("ce ma interseaza " + cardOfUserNr1.getParent());

        assert (bankAccOfUser1 == cardOfUserNr1.getParent());


//        userNumberOne.addBankAccount(bankAccOfUser1);


    }
}
