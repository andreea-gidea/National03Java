package andreea.tema1;

import java.util.Scanner;

public class Tema7CalcContinuu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The calculator will run as long as you write 'yes'");
        String run = "yes";

        do  {
            System.out.println("insert first number");
            int n1 = sc.nextInt();
            System.out.println("insert second number");
            int n2 = sc.nextInt();
            System.out.println("insert operation");
            String s = sc.next();
            int result;
            if (s.equals("+")) {
                result = n1 + n2;
                System.out.println("The sum is =" + result);
            } else if (s.equals("-")) {
                result = n1 - n2;
                System.out.println("The result of subtraction is =" + result);
            } else if (s.equals("*")) {
                result = n1 * n2;
                System.out.println("The product is =" + result);
            } else if (s.equals("/") && n2 != 0) {
                result = n1 / n2;
                System.out.println("The result of the division is =" + result);
            } else
                System.out.println("The operation is not valid");
            System.out.println("write 'yes'if you want to run the calculator");
            run = sc.next();
        }
        while (run.equals("yes"));

        System.out.println("You have not said 'yes'. Thank you for using the calculator");
    }
}

