package andreea.tema1;

import java.util.Scanner;

public class Tema3MaxDigit {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("introduceti numarul de comparat. trebuie sa aiba mai multe de o cifra");
        int number=scan.nextInt();
        int max=number%10;
        number=number/10;
        for (;number!=0;number=number/10){
            if (max<number%10){
                max=number%10;
            }
        }
        System.out.println("Cea mai mare cifra din numar este "+max);


    }
}
