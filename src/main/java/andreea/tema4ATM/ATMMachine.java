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
                    return sum;
                } else {
                    System.out.println("nu ai b ani saracrule");
//                    return 0;
                }
            } else {
                System.out.println("Pin incorect");
//                return 0;
            }
        }
        else {
            System.out.println("Card expired");
//            return 0;
        }
        return 0;
    }
//    public void deposit(int sum, Card c, String pin){
//        if (c.getCardPin().equals(pin){
//            c.getParent().setBalance()=c.getParent().
//        }
//        else{
//            System.out.println();
//        }
//    }


}

