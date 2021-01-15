package andreea.tema1;


import java.util.Arrays;
import java.util.Scanner;

public class HackerRanK {

    public static void main(String[] args) {
        String s = "Andreea";

        char[] ch = s.toCharArray();
        char[] out = new char[s.length()];

        out[0]=ch[0];
        int posInOut=1;
        int i=1;
        System.out.println(out[0]);


        while ( i<s.length()) {  //trece prin sir
            boolean allreadyInChar=false;
            for (int j=1; j<s.length(); j++){//trece prin sirul iar
                if (ch[i] == ch[j] && i!=j){
                    allreadyInChar=true;
                    System.out.println("am ajuns aici!");
                }
            }
            if (allreadyInChar==false){
                out[posInOut]=ch[i];
                posInOut++;
            }i++;
        }
        for (int k=0; k<out.length;k++)
            System.out.println(out[k]);

        String trulyOut = new String(out);
        System.out.println(trulyOut);

    }

}




