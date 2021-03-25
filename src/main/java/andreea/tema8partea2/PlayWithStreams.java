package andreea.tema8partea2;



import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithStreams {
    public static void main(String[] args) {

        /*
         *Find all transactions in the year 2011 and sort them by value (small to high). -1
         *What are all the unique cities where the traders work? -2
         *Find all traders from Cambridge and sort them by name. -3
         *Return a string of all traders’ names sorted alphabetically. -4
         *Are any traders based in Milan? -5
         *Print all transactions’ values from the traders living in Cambridge. -6
         *What’s the highest value of all the transactions? -7
         *Find the transaction with the smallest value.
         */

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader mark = new Trader("Mark", "Dusseldorf");

        Transaction transaction1 = new Transaction(1000, 2021, raoul);
        Transaction transaction2 = new Transaction(1500, 2021, mario);
        Transaction transaction3 = new Transaction(100, 2020, alan);
        Transaction transaction4 = new Transaction(100, 2020, alan);
        Transaction transaction5 = new Transaction(1200, 2021, brian);
        Transaction transaction6 = new Transaction(1200, 2021, raoul);
        Transaction transaction7 = new Transaction(1300, 2021, brian);
        Transaction transaction8 = new Transaction(100, 2020, mark);
        Transaction transaction9 = new Transaction(200, 2021, brian);
        Transaction transaction10 = new Transaction(134, 2021, raoul);
        Transaction transaction11 = new Transaction(1300, 2021, brian);
        Transaction[] transactions = {transaction1, transaction2, transaction3, transaction5, transaction6, transaction4,transaction5 ,transaction6, transaction7, transaction8, transaction9, transaction10, transaction11};

        findTransactionsIn2021AndSortByValue(transactions);

        findTheCitesWhereTradesWork(transactions);

        findTradersFromCambridgeAndSort(transactions);

        String s = findTradersNames(transactions);
        System.out.println(s);

        getMilanTraders(transactions);

        printTransactionValuesFromCambridgeTraders(transactions);

        findHighestValueOfTransaction(transactions);

        findSmallestValueOfTransaction(transactions);


    }
    private static void findTransactionsIn2021AndSortByValue(Transaction[] transactions) {
        Stream.of(transactions)
                .filter(transaction -> transaction.getYear() == 2021)
                .sorted((tr1, tr2) -> tr1.getValue() - tr2.getValue())
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
    }

    private static void findTheCitesWhereTradesWork(Transaction[] transactions) {
        Stream.of(transactions)
                .map(p ->p.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    private static void findTradersFromCambridgeAndSort(Transaction[] transactions) {
        Stream.of(transactions)
                .filter(p ->p.getTrader().getCity().equals("Cambridge"))
                .map(p->p.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    private static String findTradersNames(Transaction[] transactions) {
        return Stream.of(transactions)
                .map(p->p.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(p->p.getName())
                .collect(Collectors.joining(","));
    }

    private static void getMilanTraders(Transaction[] transactions) {
        long nrTradersFromMilan = Stream.of(transactions)
                .filter(p -> p.getTrader().getCity().equals("Milan"))
                .map(p -> p.getTrader())
                .count();
        if(nrTradersFromMilan>=0){
            System.out.println("There are "+nrTradersFromMilan+ " traders from milan");
        }else {
            System.out.println("There are no traders from Milan");
        }

    }
    private static void printTransactionValuesFromCambridgeTraders (Transaction[] transactions) {
        Stream.of(transactions)
                .filter(p ->p.getTrader().getCity().equals("Cambridge"))
                .map(p->p.getValue())
                .forEach(System.out::println);
    }
    private static void findHighestValueOfTransaction (Transaction[] transactions) {
        Optional<Integer> integerOptional= Stream.of(transactions)
                .map(p ->p.getValue())
                .max(Comparator.comparingInt(p->p));
        System.out.println(integerOptional);
    }
    private static void findSmallestValueOfTransaction (Transaction[] transactions) {
        Optional<Integer> integerOptional= Stream.of(transactions)
                .map(p ->p.getValue())
                .min(Comparator.comparingInt(p->p));
        System.out.println(integerOptional);
    }
}
