package andreea.tema2;

import java.util.Scanner;

public class Tema11ZileLunaRefactored {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the index of the month");
        String index = sc.next();
        findNumberOfDays(sc, index);
    }

    public static void findNumberOfDays(Scanner sc, String index) {
        if (index.equals(String.valueOf(1)) | index.equals(String.valueOf(3)) | index.equals(String.valueOf(5)) | index.equals(String.valueOf(7)) | index.equals(String.valueOf(8)) | index.equals(String.valueOf(10)) | index.equals(String.valueOf(12))) {
            System.out.println("The number of days in this month is equal to 31");
        } else if (index.equals(String.valueOf(2))) {
            System.out.println("What year");
            int year = sc.nextInt();
            if (year % 4 == 0)
                System.out.println("The number of days is 29");
            else
                System.out.println("the number of days is 28");
        } else if (index.equals(String.valueOf(4)) | index.equals(String.valueOf(6)) | index.equals(String.valueOf(9)) | index.equals(String.valueOf(11))) {
            System.out.println("The number of days in this month is equal to 30");
        } else
            System.out.println("Invalid number of month");

        sc.close();
    }
}
