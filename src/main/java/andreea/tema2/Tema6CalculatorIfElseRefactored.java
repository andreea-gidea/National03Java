package andreea.tema2;

import java.util.Scanner;

public class Tema6CalculatorIfElseRefactored {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("insert first number");
        int n1 = sc.nextInt();
        System.out.println("insert second number");
        int n2 = sc.nextInt();
        System.out.println("insert operation");
        String s = sc.next();
        sc.close();
        int result=CalculateBasicOperation(n1, n2, s);
        System.out.println("The result of operation is=" + result);
    }

    public static int CalculateBasicOperation(int n1, int n2, String s) {
        int result=0;
        if (s.equals("+")) {
            result = n1 + n2;
            //System.out.println("The sum is =" + result);
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
        return (result);
    }
}
