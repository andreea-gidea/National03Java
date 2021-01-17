package andreea.tema4ATM;


import java.time.LocalDateTime;

public class ATMMachine {

    public boolean checkValability(Card c) {
        return c.getExpirationDate().isAfter(LocalDateTime.now());
    }

    public int withdraw(int sum, Card c, String pin) {
        if (checkValability(c)) {
            if (c.getCardPin().equals(pin)) {
                if (c.getParent().getBalance() >= sum) {
                    c.getParent().setBalance(c.getParent().getBalance() - sum);
                    System.out.println("Here is your money  ");
                    return sum;
                } else {
                    System.out.println("Not enough money in your account");
//                    return 0;
                }
            } else {
                System.out.println("Incorrect pin");
//                return 0;
            }
        }
        else {
            System.out.println("Card expired");
//            return 0;
        }
        return 0;
    }
    public void deposit(int sum, Card c, String pin){
        if (c.getCardPin().equals(pin)){
            c.getParent().setBalance(c.getParent().getBalance()+sum);
            System.out.println("Your new balance is  "+c.getParent().getBalance());
        }
        else{
            System.out.println("Incorrect pin");
        }
    }
    public void changePin (Card c, String oldPin , String newPin){
        if (c.getCardPin().equals(oldPin)){
            c.setCardPin(newPin);
            System.out.println("Your pin has changed");
        }
        else{
            System.out.println("Incorrect pin");
        }
    }
    public void interrogateBalance( Card c, String pin){
        if (c.getCardPin().equals(pin)){
            System.out.println("Your balance is  "+c.getParent().getBalance());
        }
        else{
            System.out.println("Incorrect pin");
        }
    }


}

