package andreea.tema2;


public class Tema8FactorialRefactored {
    public static void main(String[] args) {

        int n = 6;
        int nFactorial = getnFactorial(n);
        System.out.println(n + "!=" + nFactorial);
    }

    public static int getnFactorial(int n) {
        int nFactorial = 1;
        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial * i;
        }
        return nFactorial;
    }
}
