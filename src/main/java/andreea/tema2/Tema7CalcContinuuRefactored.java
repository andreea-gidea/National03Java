package andreea.tema2;

import java.util.Scanner;

public class Tema7CalcContinuuRefactored {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The calculator will run as long as you write 'yes'");
        String run;

        do {
            System.out.println("insert first number");
            int n1 = sc.nextInt();
            System.out.println("insert second number");
            int n2 = sc.nextInt();
            System.out.println("insert operation");
            String s = sc.next();
            int result=calculateBasicOp(n1, n2, s);
            System.out.println(result);
            System.out.println("write 'yes'if you want to run the calculator");
            run = sc.next();
        }
        while (run.equals("yes"));

        System.out.println("You have not said 'yes'. Thank you for using the calculator");
        sc.close();
    }

    public static int calculateBasicOp(int n1, int n2, String s) {
        int result = 0;
        if (s.equals("+")) {
            result = n1 + n2;
           // System.out.println("The sum is =" + result);
        } else if (s.equals("-")) {
            result = n1 - n2;
            //System.out.println("The result of subtraction is =" + result);
        } else if (s.equals("*")) {
            result = n1 * n2;
            //System.out.println("The product is =" + result);
        } else if (s.equals("/") && n2 != 0) {
            result = n1 / n2;
            //System.out.println("The result of the division is =" + result);
        } else
            System.out.println("The operation is not valid");
        return(result);
    }
}

