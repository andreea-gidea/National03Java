package andreea.tema8partea2;

public class Transaction {

    private final int value;
    private final int year;
    private final Trader trader;

    public Transaction(int value, int year, Trader trader) {
        this.value = value;
        this.year = year;
        this.trader = trader;
    }

    public int getValue() {
        return value;
    }

    public int getYear() {
        return year;
    }

    public Trader getTrader() {
        return trader;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", year=" + year +
                ", trader=" + trader +
                '}';
    }
}
