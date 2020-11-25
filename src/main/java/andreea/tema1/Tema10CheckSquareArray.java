package andreea.tema1;

public class Tema10CheckSquareArray {
    public static void main(String[] args) {

        int arraySquare[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int arrayNotSquare[][] = {{1, 3}, {4, 5, 6}, {7, 8, 9}};
        if (isSquare(arraySquare) == true)
            System.out.println("Array is square");
        if (isSquare(arrayNotSquare) == true)
            System.out.println("Array is square");
        else
            System.out.println("Array not square");


    }

    public static boolean isSquare(int[][] array) {
        int firstLevelElements = 0;
        boolean square = true;
        for (int i = 0; i < array.length; i++) {
            firstLevelElements = firstLevelElements + 1;
            int secondLevelElements = 0;
            for (int j = 0; j < array[i].length; j++) {
                secondLevelElements = secondLevelElements + 1;
            }
            if (array.length != secondLevelElements) {
                square = false;
            }
        }
        if (square == true) {
            // System.out.println("The array is square");
            return square;
        } else
            //System.out.println("The array is not square");
            return square;
    }
}
