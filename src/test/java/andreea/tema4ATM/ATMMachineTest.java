package andreea.tema4ATM;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDateTime;


@RunWith(MockitoJUnitRunner.class)
public class ATMMachineTest {

    @InjectMocks
    private static ATMMachine ATMMachine;

    private static Card cardMock = Mockito.mock(Card.class);
    private static BankAccount bankAccount = Mockito.mock(BankAccount.class);
//    BankAccount bankAccOfUser1 = new BankAccount("ROZBR124", 123, 1);
//    Card cardOfUserNr1 = new Card("098255", LocalDateTime.of(2022, Month.APRIL, 01, 00, 00), "1234");
//    bankAccOfUser1.addCard(cardOfUserNr1);
//    private Card cardMock = Mockito.mock(Card.class);
//    @Mock
//    private Card cardMock ;

//    @InjectMocks
//    BankAccount bankAccount = new BankAccount("Ro16739398",100,1);

    @BeforeClass
    public static void setup(){
        Mockito.when(bankAccount.getBalance()).thenReturn(10);
        Mockito.when(cardMock.getCardPin()).thenReturn("1234");
        Mockito.when(cardMock.getParent()).thenReturn(bankAccount);
    }


    @Test
    public void checkValabilityTest() {
        Card cardMock = Mockito.mock(Card.class);
        Mockito.when(cardMock.getExpirationDate()).thenReturn(LocalDateTime.MIN);
//        Mockito.doReturn(LocalDateTime.MIN).when(cardMock.getExpirationDate());

        boolean b = ATMMachine.checkValability(cardMock);
        Assert.assertEquals(false, b);
    }


    @Test
    public void withdrawTest() {

        Mockito.when(cardMock.getExpirationDate()).thenReturn(LocalDateTime.of(2022, 04, 01, 0, 0));
        int b = ATMMachine.withdraw(10, cardMock,"1234");
        Assert.assertEquals(10, b);
    }

    @Test
    public void withdrawTestNotEnoughMoneyTest() {

        Mockito.when(cardMock.getExpirationDate()).thenReturn(LocalDateTime.of(2022, 04, 01, 0, 0));
        int b = ATMMachine.withdraw(20, cardMock,"1234");
        Assert.assertEquals(0, b);
    }

    @Test
    public void withdrawTestIncorrectPinTest() {

        Mockito.when(cardMock.getExpirationDate()).thenReturn(LocalDateTime.of(2022, 04, 01, 0, 0));
        int b = ATMMachine.withdraw(10, cardMock,"1235");
        Assert.assertEquals(0, b);
    }

    @Test
    public void withdrawTestCardExpiredTest() {

        Mockito.when(cardMock.getExpirationDate()).thenReturn(LocalDateTime.now());
        int b = ATMMachine.withdraw(10, cardMock,"1234");
        Assert.assertEquals(0, b);
    }

    @Test
    public void depositTest() {

        Mockito.when(cardMock.getExpirationDate()).thenReturn(LocalDateTime.of(2022, 04, 01, 0, 0));
        ATMMachine.deposit(10, cardMock,"1234");
    }

    @Test
    public void depositIncorrectPinTest() {

        Mockito.when(cardMock.getExpirationDate()).thenReturn(LocalDateTime.of(2022, 04, 01, 0, 0));
        ATMMachine.deposit(10, cardMock,"1235");
    }

    @Test
    public void depositExpiredTest() {

        Mockito.when(cardMock.getExpirationDate()).thenReturn(LocalDateTime.now());
        ATMMachine.deposit(10, cardMock,"1234");
    }

    @Test
    public void changePinTest() {

        ATMMachine.changePin(cardMock,"1234", "1235");
    }

    @Test
    public void changePinIncorrectTest() {

        ATMMachine.changePin(cardMock,"1235", "1235");
    }

    @Test
    public void interrogateBalanceTest() {

        ATMMachine.interrogateBalance(cardMock,"1234");
    }

    @Test
    public void interrogateBalancePinIncorrectTest() {

        ATMMachine.interrogateBalance(cardMock,"1235");
    }
}
