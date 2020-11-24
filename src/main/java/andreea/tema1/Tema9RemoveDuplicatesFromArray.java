package andreea.tema1;


public class Tema9RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] initial = {20, 20, 30, 40, 50, 50, 50};
        int[] forCollectingNonDuplicates = new int[initial.length];
        int newArrayLength = 1;
        forCollectingNonDuplicates[0] = initial[0];
        int k = 1;//folosit pentru a determina poz in array de output
        for (int i = 1; i < initial.length; i++) {//ia fiecare element din sirul initial
            boolean esteDuplicat = false;//presuppunem ca nu este duplicat
            for (int j = 0; forCollectingNonDuplicates[j] != 0; j++) {//ia fiecare valoare din sirul de output
                if (initial[i] == forCollectingNonDuplicates[j]) {//compara valoarea din input cu toate valorile din output,decidem daca e duplicat
                    esteDuplicat = true;
                }
            }
            if (!esteDuplicat) {
                forCollectingNonDuplicates[newArrayLength] = initial[i];
                newArrayLength = newArrayLength + 1;
            }
        }
        System.out.println("The length of the new array is=" + newArrayLength);
        int[] outValues = new int[newArrayLength];
        for (int i = 0; i < outValues.length; i++) {
            outValues[i] = forCollectingNonDuplicates[i];
            System.out.print(outValues[i] + " ");
        }
    }
}

