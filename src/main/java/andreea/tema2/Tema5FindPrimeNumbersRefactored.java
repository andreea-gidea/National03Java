package andreea.tema2;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Tema5FindPrimeNumbersRefactored {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the maximum number to witch you want the search of prime numbers");
        int numMax = sc.nextInt();//numarul pana unde se cauta
        sc.close();
        int [] thePrimes=getPrimes(numMax);
        for (int k = 0; k < thePrimes.length; k++) {
                System.out.print(" "+thePrimes[k]);
          }


    }

    public static int[] getPrimes(int numMax) {
        int[] primeNumbers = new int[200];
        boolean isPrime;//decide daca un numar este prim
        int numberOfPrimes = 0;
        if (numMax <= 1) {
            System.out.println("The number should be greater than 1");
        } else if (numMax == 2) {
            System.out.println("The only prime number lower or equal to 2 is 2");
        } else if (numMax >= 1223) {
            System.out.println("Please insert a number lower than 1224");
        } else {
            int positionInArray = 0;
            for (int i = 3; i <= numMax; i += 2) {
                int j = 3;//takes all numbers that could divide the supposed prime number
                isPrime = true;//assume it is prime
                while (j <= sqrt(i)) {//proves if it is not prime
                    if (i % j == 0) {
                        isPrime = false;
                    }
                    j = j + 1;
                }
                if (isPrime == true) {
                    primeNumbers[positionInArray] = i;
                    positionInArray = positionInArray + 1;
                }
            }
            numberOfPrimes = positionInArray;
        }
        if (numberOfPrimes>1){
        int arrayOfPrimes[] = new int[numberOfPrimes + 1];
        arrayOfPrimes[0] = 2;
        for (int k = 1; k <= numberOfPrimes; k++){
            arrayOfPrimes[k]=primeNumbers[k-1];
        }

        return(arrayOfPrimes);

//        if (numberOfPrimes >= 1) {
//            System.out.println("there are " + (numberOfPrimes+1) + " prime numbers found :");
//            System.out.print("2");
//            for (int k = 0; k < numberOfPrimes; k++) {
//                System.out.print(" "+primeNumbers[k]);
//            }
    }else {
            int arrayNoPrimes[]=new int[1];
            return (arrayNoPrimes);
        }
    }
}


