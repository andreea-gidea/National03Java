package andreea.tema4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class StringManipulationTest {
    @InjectMocks
    private StringManipulation stringManipulation;

    @Test

    public void testStringReversed() {
        String s = "Andreea";
        String out = stringManipulation.reverseString(s);
        Assert.assertEquals("aeerdnA", out);
    }

    @Test

    public void testCheckIfAnagram() {
        String s1 = "cal";
        String s2 = "lac";
        boolean out = stringManipulation.checkIfAnagrams(s1, s2);
        Assert.assertEquals(true, out);
    }

    @Test

    public void testCheckIfAnagramFalse() {
        String s1 = "calc";
        String s2 = "lac";
        boolean out = stringManipulation.checkIfAnagrams(s1, s2);
        Assert.assertEquals(false, out);
    }


    @Test

    public void testContainsOnlyDigits() {
        String s = "Trala2";
        boolean out = stringManipulation.containsOnlyDigits(s);
        Assert.assertEquals(false, out);
    }

    @Test

    public void testContainsOnlyDigitsFalse() {
        String s = "Andreea";
        boolean out = stringManipulation.containsOnlyDigits(s);
        Assert.assertEquals(true, out);
    }

    @Test

    public void testContainsVowelsAndCons() {
        String s = "Andreea";
        int[] expected = {4, 3};
        int[] out = stringManipulation.findNrOfVowelsAndConsonants(s);
        Assert.assertArrayEquals(expected, out);
    }

    @Test

    public void testOccurenceOfChar() {
        String s = "Blablabla";
        int i = stringManipulation.occurenceOfChar(s, "a");
        Assert.assertEquals(3, i);
    }

    @Test

    public void testStringToInt() {
        String s = "1203465798";
        int out = stringManipulation.stringToInt(s);
        Assert.assertEquals(1203465798, out);
    }

    @Test

    public void testStringToIntNeg() {
        String s = "-1523";
        int out = stringManipulation.stringToInt(s);
        Assert.assertEquals(-1523, out);
    }
    @Test

    public void testStringToIntPos() {
        String s = "+1523";
        int out = stringManipulation.stringToInt(s);
        Assert.assertEquals(1523, out);
    }


    @Test

    public void testStringToIntInvalidInput() {
        String s = "-1d23";
        int out = stringManipulation.stringToInt(s);
        Assert.assertEquals(0, out);
    }

    @Test

    public void testReverseWords() {
        String s = "Unde dai si unde crapa";
        String out = stringManipulation.reverseWords(s,2,5);
        Assert.assertEquals("Unde crapa si unde dai ", out);
    }

    @Test

    public void testFindIfRotation() {
        String s1 = "cal";
        String s2 = "lac";
        boolean out = stringManipulation.findIfAreRotation(s1,s2);
        Assert.assertEquals(true, out);

    }
    @Test

    public void testFindIfRotationFalse() {
        String s1 = "ana";
        String s2 = "are";
        boolean out = stringManipulation.findIfAreRotation(s1,s2);
        Assert.assertEquals(false, out);

    }
    @Test

    public void testIfPalindrom() {
        String s1 = "ana";
        boolean out = stringManipulation.isPalindrom(s1);
        Assert.assertEquals(true, out);

    }
    @Test

    public void testIfPalindromFalse() {
        String s1 = "cal";
        boolean out = stringManipulation.isPalindrom(s1);
        Assert.assertEquals(false, out);

    }
    @Test

    public void testLengthOfNonrepeatingCar() {
        String s1 = "Andreea";
        int out = stringManipulation.lengthOfNonRepeatingCharacters(s1);
        Assert.assertEquals(5, out);

    }
    @Test

    public void testRemoveDuplicatesFronStringr() {
        String s1 = "Andreea";
        String out = stringManipulation.removeDuplicatesFromString(s1);
        Assert.assertEquals("Andra", out);

    }
    @Test

    public void testRemoveGivenCharFromString() {
        String s1 = "Ana are mere";
        String out = stringManipulation.removeGivenCharacterFromString(s1, "e");
        Assert.assertEquals("Ana ar mr", out);

    }


}
