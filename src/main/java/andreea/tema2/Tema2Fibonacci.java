package andreea.tema2;

public class Tema2Fibonacci {
    public static void main(String[] args) {
        int numberofTerms = 25;
        printFibonacciSeries(numberofTerms);
    }

    public static void printFibonacciSeries(int numberofTerms) {
        int[] terms = new int[numberofTerms];
        terms [0]=1;
        terms [1]=1;
        for (int i = 2; i < numberofTerms; i++) {
            terms[i] = terms[i-1]+terms[i-2];
        }
        for (int k = 0; k<numberofTerms;k++){
            System.out.print(" "+terms[k]);
        }
    }
}
