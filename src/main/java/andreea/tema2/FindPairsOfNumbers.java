package andreea.tema2;

public class FindPairsOfNumbers {
    public static void main(String[] args) {
        int [] numbers={10, 4, 5, 3, 9, 6, 0, 25, -10};
        int numberSum=9;
        findNumbersOfSumEqualTo(numbers, numberSum);
    }

    public static void findNumbersOfSumEqualTo(int[] numbers, int numberSum) {
        for (int i=0 ; i<numbers.length ; i++){
            for (int j=i+1 ; j<numbers.length ; j++){
                if (numberSum==numbers[i]+numbers[j])
                    System.out.println(numbers[i]+" + "+ numbers[j]+" = "+numberSum);
            }
        }
    }
}
