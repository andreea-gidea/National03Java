package andreea.tema1;

import java.util.Scanner;

public class Tema4Palindrom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("introduceti numarul de comparat. trebuie sa aiba mai multe de o cifra");
        int number = scan.nextInt();
        scan.close();
        int numberAnlerated = number;
        int maybePalindrom = 0;
        for (; numberAnlerated > 0; numberAnlerated = numberAnlerated / 10) {
            maybePalindrom = 10 * maybePalindrom + numberAnlerated % 10;
        }
        if (number == maybePalindrom) {
            System.out.println("Numarul introdus este palindrom");
        } else
            System.out.println("Numarul introdus nu este palindrom");


    }


}
