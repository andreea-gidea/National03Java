package andreea.tema2;

import java.util.Scanner;

import static andreea.tema2.Tema2SmallersNumberInArrayForEachRefactored.getInts;
import static andreea.tema2.Tema2SmallersNumberInArrayForEachRefactored.getMin;

public class Tema2SmallestNumberInArrayForRefactored {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numarul numarul de numere de comparat");
        int n = scan.nextInt();
        int[] sir = getInts(scan, n);
//        int sir[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            System.out.println("Introduceti elementul cu numarul  " + (i + 1));
//            sir[i] = scan.nextInt();
//        }
        int min = getMin(sir);
//        min = sir[0];
//        for (int j = 0; j < n; j++) {
//            if (min > sir[j]) {
//                min = sir[j];
//            }
//        }
        scan.close();
        System.out.println("Minimul este  " + min);


    }
}
