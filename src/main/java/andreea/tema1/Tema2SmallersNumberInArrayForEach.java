package andreea.tema1;

import java.util.Scanner;

public class Tema2SmallersNumberInArrayForEach {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numarul numarul de numere de comparat");
        int n = scan.nextInt();
        int sir[] = new int[n];
        int min;

        for (int i=0;i<n; i++){
            System.out.println("Introduceti elementul cu numarul  "+(i+1));
            sir[i]=scan.nextInt();
        }

        min = sir[0];
        for (int num2 : sir) {
            if (min > num2) {
                min = num2;
            }
        }
        System.out.println("Minimul este  "+min);
    }
}
