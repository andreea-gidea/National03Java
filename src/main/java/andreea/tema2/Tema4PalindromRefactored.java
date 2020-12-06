package andreea.tema2;

import java.util.Scanner;

public class Tema4PalindromRefactored {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("introduceti numarul de comparat. trebuie sa aiba mai multe de o cifra");
        int number = scan.nextInt();
        scan.close();
        boolean isItPalindrom=isPalindrom(number);
        if (isItPalindrom==true) {
            System.out.println("The number is palindrom");
        }else
            System.out.println("The number is not a palindrom");


    }

    public static boolean isPalindrom(int number) {
        int numberAnlerated = number;
        int maybePalindrom = 0;
        boolean isPalindrom;
        for (; numberAnlerated > 0; numberAnlerated = numberAnlerated / 10) {
            maybePalindrom = 10 * maybePalindrom + numberAnlerated % 10;
        }
        if (number == maybePalindrom) {
            isPalindrom=true;
            System.out.println("Numarul introdus este palindrom");
        } else {
            System.out.println("Numarul introdus nu este palindrom");
            isPalindrom = false;
        }
        return isPalindrom;
    }


}
