package andreea.tema4ATM;


import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        User userNumberOne = new User("Andreea Gidea");//create new user
        BankAccount bankAccOfUser1= new BankAccount("ROZBR124" , 123);//opening bank account
        Card cardOfUserNr1 = new Card("098255" , LocalDateTime.of(2021, Month.APRIL, 01,00,00),"1234");//create card
        bankAccOfUser1.addCard(cardOfUserNr1);//attach card to bank account
        userNumberOne.addBankAccount(bankAccOfUser1);  //give the bank account to the user
        ATMMachine ATM1=new ATMMachine();//we need an ATM to make stuff
        ATM1.withdraw(10,cardOfUserNr1,"1234");//get money
        ATM1.deposit(100, cardOfUserNr1,"1234");//deposit money
        ATM1.interrogateBalance(cardOfUserNr1, "1234");
        ATM1.changePin(cardOfUserNr1, "1234", "2345");//change pin

    }
}
