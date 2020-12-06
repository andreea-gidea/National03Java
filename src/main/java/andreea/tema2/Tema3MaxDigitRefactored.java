package andreea.tema2;

import java.util.Scanner;

public class Tema3MaxDigitRefactored {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("introduceti numarul de comparat. trebuie sa aiba mai multe de o cifra");
        int number = scan.nextInt();
        scan.close();
        int max=findMaxDigit(number);
        System.out.println("The max digit of the number is="+max);


    }

    public static int findMaxDigit(int number) {
        int max = number % 10;
        number = number / 10;
        for (; number != 0; number = number / 10) {
            if (max < number % 10) {
                max = number % 10;
            }
        }
        return(max);

    }
}
