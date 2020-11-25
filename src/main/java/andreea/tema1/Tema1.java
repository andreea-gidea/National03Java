package andreea.tema1;

import static java.lang.Math.sqrt;

public class Tema1 {
    public static void main(String[] args) {
        int sum = 2;
        int nrPrime = 1;
        boolean estePrim;
        for (int i = 3; nrPrime < 100; i += 2) {
            int j = 3;
            estePrim = true;
            while (j <= sqrt(i)) {
                if (i % j == 0) {
                    estePrim = false;
                }
                j = j + 1;
            }
            if (estePrim == true) {
                sum = sum + i;
                nrPrime = nrPrime + 1;
            }
        }
        System.out.println("Suma primelor 100 numere prime este" + sum);
    }

}
