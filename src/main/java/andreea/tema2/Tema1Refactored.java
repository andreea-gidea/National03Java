package andreea.tema2;

import static java.lang.Math.sqrt;

public class Tema1Refactored {
    public static void main(String[] args) {


        int s=calculateSumNPrimes(4);
        System.out.println(s);

    }

    public static int calculateSumNPrimes(int n) {
        int nrPrime = 1;//keeps track of numbers of primes
        int sum = 2;//keeps sum
        boolean estePrim;//true if a number is a prime
        for (int i = 3; nrPrime < n; i += 2) {//goes from the second prime number to the nth prime number
            int j = 3;//represents the number we check with too see if nr is prime
            estePrim = true;
            while (j <= sqrt(i)) {
                if (i % j == 0) {
                    estePrim = false;
                }
                j = j + 1;
            }
            if (estePrim == true) {
                sum = sum + i;
                nrPrime = nrPrime + 1;
            }
        }
        return(sum);
    }


}
