package andreea.tema2;

import static org.apache.commons.lang3.CharSequenceUtils.toCharArray;

public class FindDuplicateCaracters {
    public static void main(String[] args) {
        String s="Please, work!";
        findDuplicates(s);
    }

    public static void findDuplicates(String s) {
        char[] arrayOfCaracters= toCharArray (s);
        char [] isDuplicate=new char[40];
        int k=0;//place in isDuplicate
        for (int i=0 ; i<arrayOfCaracters.length ; i++)
        {
            for (int j=i+1 ; j<arrayOfCaracters.length ; j++){
                if (arrayOfCaracters[i]==arrayOfCaracters[j]){
                    isDuplicate[k]=arrayOfCaracters[i];
                    k=k+1;
                }
            }
        }
        for (int l=0 ; l<k ; l++)
            System.out.print(isDuplicate[l]+",  ");
    }
}
