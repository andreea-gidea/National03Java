package andreea.tema8partea1;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int numberOfFibonacciElements = 100;
        BigInteger[] listOfFibonacci = GenerateFirstNFibonacciSeriesElem(numberOfFibonacciElements);
    }
    private static BigInteger[] GenerateFirstNFibonacciSeriesElem(int n) {
        BigInteger[] listOfFibonacci =
                Stream.iterate(new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(1)}, p -> new BigInteger[]{p[1], p[0].add(p[1])})
                        .limit(n)
                        .map(p -> new BigInteger(String.valueOf(p[0])))
                        .toArray(BigInteger[]::new);
        for(BigInteger b:listOfFibonacci){
            System.out.println(b);
        }
        return listOfFibonacci;
    }
}
