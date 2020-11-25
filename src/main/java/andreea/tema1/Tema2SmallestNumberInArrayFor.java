package andreea.tema1;

import java.util.Scanner;

public class Tema2SmallestNumberInArrayFor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numarul numarul de numere de comparat");
        int n = scan.nextInt();
        int sir[] = new int[n];
        int min;

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceti elementul cu numarul  " + (i + 1));
            sir[i] = scan.nextInt();
        }
        min = sir[0];
        for (int j = 0; j < n; j++) {
            if (min > sir[j]) {
                min = sir[j];
            }
        }
        scan.close();

        System.out.println("Minimul este  " + min);


    }
}
