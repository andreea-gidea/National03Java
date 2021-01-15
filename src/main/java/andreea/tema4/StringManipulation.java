package andreea.tema4;

import java.util.Arrays;


public class StringManipulation {

    public static void main(String[] args) {
//        String s = "andreea";
//
//        //reverse string
//        String intors = reverseString(s);
//
//        //print duplicates
//        printDuplicates(s);
//
//        //string Anagram
//        String anagram1 = "lacul";
//        String anagram2 = "calul";
//        checkIfAnagrams(anagram1, anagram2);
//        if (checkIfAnagrams(anagram1, anagram2)) {
//            System.out.println("IT IIS ANAGRAM");
//        } else {
//            System.out.println("Not anagram :(");
//
//            //checkonly char
//        }
//        String pentruCaractere = "Andor67lala";
//        if (containsOnlyDigits(pentruCaractere)) {
//            System.out.println("It contains only characters");
//        } else {
//            System.out.println("It does not contain only characters");
//        }
//
//        //find vowels and consonants
//        String forVowels = "Ana are mere ";
//        int[] nrVocaleConsoane = findNrOfVowelsAndConsonants(forVowels);
//        System.out.println("Vocale: " + nrVocaleConsoane[0] + "  Consoane: " + nrVocaleConsoane[1]);
//
//        //number of occurences
//        System.out.println("Caracterul se repeta de " + occurenceOfChar("Aici este 'i' de 4 ori", "i") + " ori");
//
//        //first non duplicate character
//        printNonRepeatedCharacter("ambramburici");
//
//        //integer number conversion from string
//        int j = stringToInt("-4123");
//        System.out.println("there you go " + j);
//
//        //Chage pos of words
//        String s3 = "This is first and that is last";
//        s3 = reverseWords(s3, 3, 7);
//        System.out.println(s3);
//
//        //Are rotation
//        findIfAreRotation("fumad", "dafmu");

        //Check is palindrom
//        if (isPalindrom("moma") == true) {
//            System.out.println("IS palindrom");
//        }

        //Longest non repeating character string
        System.out.println("Longest non repeating char string is of length " + lengthOfNonRepeatingCharacters("Si eu ce sa fac?"));
        //Remove duplicates from string
        System.out.println("Duplicates removed:  " + removeDuplicatesFromString("Andreea"));
        //Remove given char froms string
        System.out.println("Here is the new string " + removeGivenCharacterFromString("Andreea", "a"));
    }

    private static String reverseString(String s) {
        char[] ch = s.toCharArray();
        char[] out = new char[s.length()];
        int j = s.length();
        for (int i = 0; i < s.length(); i++) {
            out[i] = ch[(s.length() - i - 1)];

        }
        String output = Arrays.toString(out);
        return output;
    }

    private static void printDuplicates(String s) {

        char[] ch = s.toCharArray();
        char[] out = new char[s.length() / 2];
        Arrays.sort(ch);
//        for (int k=0; k<ch.length;k++)
//            System.out.println("inainte  "+ch[k]);
        int j = 0;
//        for (int k=0; k<ch.length;k++)
//            System.out.println(ch[k]);
        for (int i = 1; i < s.length(); i++) {
            if (ch[i] == ch[i - 1] && j <= 0) {
                out[j] = ch[i];
                j++;
            } else if (ch[i] == ch[i - 1] && j > 0 && ch[i] != out[j - 1]) {
                out[j] = ch[i];
                j++;
            }

        }
        for (int k = 0; k < j; k++)
            System.out.println("Litera ce se repeta este   " + out[k]);
//        printArray(out);
    }

    private static void printArrayOfChar(char[] chars) {
        for (int i : chars) {
            System.out.println(chars);
        }

    }

    private static Boolean checkIfAnagrams(String a, String b) {
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        boolean isAnagram = false;
        if (a.length() != b.length()) {
            return isAnagram;
        } else {
            isAnagram = true;
            for (int i = 0; i < a.length(); i++) {
                if (ch1[i] != ch2[i])
                    return false;
            }
            return isAnagram;
        }
    }

    //    private static void findPermutations(String s) {
//        char[] ch = s.toCharArray();
//        char[] out=new char[s.length()];
//        int j=s.length();
//        for (int i=0 ; i<s.length(); i++){
//            out [i]=ch [(s.length()-i-1)];
//
//        }
//        String output= Arrays.toString (out);
//
//    }
    private static Boolean containsOnlyDigits(String s) {
        String stringOtherCharRemoved = s.replaceAll("[^a-zA-Z]", "");
        if (s.length() == stringOtherCharRemoved.length()) {
            return true;
        } else
            return false;

    }

    private static int[] findNrOfVowelsAndConsonants(String s) {
        s = s.replaceAll("[^a-zA-Z]", "");
        String[] split = s.split("");
        int nrOfVowels = 0;
        int nrOfConsonants = 0;
        for (int i = 0; i < s.length(); i++) {
            if (split[i].equals("a") || split[i].equals("e") || split[i].equals("i") || split[i].equals("o") || split[i].equals("u") || split[i].equals("A") || split[i].equals("E") || split[i].equals("I") || split[i].equals("O") || split[i].equals("U")) {
                nrOfVowels = nrOfVowels + 1;
            } else nrOfConsonants = nrOfConsonants + 1;
        }
        int[] output = {nrOfVowels, nrOfConsonants};
        return output;

    }

    private static int occurenceOfChar(String s, String c) {

        String[] split = s.split("");
        int nrOfOccurences = 0;

        for (int i = 0; i < s.length(); i++) {
            if (split[i].equals(c)) {
                nrOfOccurences++;
            }
        }
        return nrOfOccurences;
    }

    private static void printNonRepeatedCharacter(String s) {

        String[] split = s.split("");

        for (int i = 0; i < s.length(); i++) {
            int numberRepetitions = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (split[i].equals(split[j])) {
                    numberRepetitions++;
                }
            }
            if (numberRepetitions == 0) {
                System.out.println(split[i]);
                break;
            }
        }

    }

    private static int stringToInt(String s) {
        String s1 = s.replaceAll("[^0-9]+-", "");

        int posOrNeg = 1;
        int i = 0;
        int integerNumber = 0;


        if (s1.length() != s.length()) {
            System.out.println("Cannot be converted");
            return 0;
        }
        if ("-".equals(String.valueOf(s.charAt(0)))) {
            posOrNeg = -1;
            i++;
        }
        if ("+".equals(String.valueOf(s.charAt(0)))) {
            posOrNeg = 1;
            i++;
        }
        for (; i < s.length(); i++) {
            int powerOf10 = (int) Math.pow(10, (s.length() - i - 1));
            switch (String.valueOf(s.charAt(i))) {

                case "0":
                    integerNumber = 0 * powerOf10 + integerNumber;
                    break;
                case "1":
                    integerNumber = 1 * powerOf10 + integerNumber;
                    break;
                case "2":
                    integerNumber = 2 * powerOf10 + integerNumber;
                    break;
                case "3":
                    integerNumber = 3 * powerOf10 + integerNumber;
                    break;
                case "4":
                    integerNumber = 4 * powerOf10 + integerNumber;
                    break;
                case "5":
                    integerNumber = 5 * powerOf10 + integerNumber;
                    break;
                case "6":
                    integerNumber = 6 * powerOf10 + integerNumber;
                    break;
                case "7":
                    integerNumber = 7 * powerOf10 + integerNumber;
                    break;
                case "8":
                    integerNumber = 8 * powerOf10 + integerNumber;
                    break;
                case "9":
                    integerNumber = 9 * powerOf10 + integerNumber;
                    break;

            }
        }
        integerNumber = integerNumber * posOrNeg;
        return integerNumber;

    }

    private static String reverseWords(String s, int i, int j) {

        String[] split = s.split(" ");
        String[] newString = split;
        String temp = newString[i - 1];
        newString[i - 1] = newString[j - 1];
        newString[j - 1] = temp;
        return Arrays.toString(newString);
    }

    private static Boolean findIfAreRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            System.out.println("No way are rotation");
            return false;
        } else for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(s1.length() - i - 1)) {
                System.out.println("Not rotation");
                return false;
            }
        }
        System.out.println("They are rotation");
        return true;

    }

    private static boolean isPalindrom(String s) {
        char[] s2 = new char[s.length()];
        char[] ch1 = s.toCharArray();
        boolean iiPalindrom = true;
        for (int i = 0; i < s.length(); i++) {
            s2[i] = ch1[s.length() - i - 1];
        }
        System.out.println(s2);
        System.out.println(ch1);
        for (int i = 0; i < s.length(); i++) {
            if (ch1[i] != s2[i]) {
                System.out.println("Nu-i palindrom ");
                return false;
            }
        }

        System.out.println("E palindrom ");
        return true;
    }

    private static int lengthOfNonRepeatingCharacters(String s) {

        char[] ch = s.toCharArray();
        char[] out = new char[s.length() / 2];
        Arrays.sort(ch);
//        for (int k=0; k<ch.length;k++)
//            System.out.println("inainte  "+ch[k]);
        int j = 0;
//        for (int k=0; k<ch.length;k++)
//            System.out.println(ch[k]);
        for (int i = 1; i < s.length(); i++) {
            if (ch[i] == ch[i - 1]) {
                j++;
            }

        }
        return (s.length() - 2 * j);
    }

    private static String removeDuplicatesFromString(String s) {

        char[] ch = s.toCharArray();
        char[] out = new char[s.length()];

        out[0] = ch[0];
        int posInOut = 1;
        int i = 1;
        System.out.println(out[0]);


        while (i < s.length()) {  //trece prin sir
            boolean allreadyInChar = false;
            for (int j = 1; j < s.length(); j++) {//trece prin sirul iar
                if (ch[i] == ch[j] && i != j) {
                    allreadyInChar = true;
//                    System.out.println("am ajuns aici!");
                }
            }
            if (allreadyInChar == false) {
                out[posInOut] = ch[i];
                posInOut++;
            }
            i++;
        }
        String trulyOut = new String(out);
        return trulyOut;
    }

    private static String removeGivenCharacterFromString(String s, String c) {

        char[] ch = s.toCharArray();
        char[] ch2 = c.toCharArray();
        char[] out = new char[s.length()];


        int posInOut = 0;
        int i = 0;
        System.out.println(out[0]);


        while (i < s.length()) {  //trece prin sir
            boolean equalsTheGivenChar = false;
                if (ch2[0]==ch[i]) {
                    equalsTheGivenChar = true;
                    System.out.println(ch2[0]+" removed");
                }
            if (equalsTheGivenChar == false) {
                out[posInOut] = ch[i];
                posInOut++;
            }
            i++;
        }
        String trulyOut = new String(out);
        return trulyOut;
    }
    private static String findMostFrequentString(String [] s) {

        String[] allreadyWentThrough=new String[s.length];//stocheaza cuvintele prin care s-a trecut
        int timesOfOccurence=0;//va numara de cate ori se gaseste un cuvant in array
        int [] timesOfOccurenceAtIndex=new int[s.length];//va pastra numarul de aparitii la indexul corespunzaator cuvantului

        for (int i=0; i<s.length; i++){
            for (int j=0; j<s.length; j++){
                //aaici am ramas
            }
        }
        return "MDA";

    }


}
