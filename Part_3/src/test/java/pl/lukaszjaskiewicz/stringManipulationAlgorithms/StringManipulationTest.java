package pl.lukaszjaskiewicz.stringManipulationAlgorithms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;

public class StringManipulationTest {

    @Test
    void countVowels_whenCalled_shouldReturnNoOfVowelsInInput(){
        String str = "A cat walked down the road.";
        String noVowelStr = "tp";

        assertEquals(8, StringManipulation.countVowels(str));
        assertEquals(0, StringManipulation.countVowels(noVowelStr));
        assertEquals(0, StringManipulation.countVowels(""));
    }

    @Test
    void revers_whenCalled_shouldReverseInputsCharacterOrder(){
        String input = "abcde";

        var list = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.reverse(list);
        var reversedInput = list.stream().map(String::valueOf).collect(Collectors.joining());

        assertEquals(reversedInput, StringManipulation.reverse(input));
        assertEquals("   ", StringManipulation.reverse("   "));
        assertEquals("", StringManipulation.reverse(""));
        assertEquals("", StringManipulation.reverse(""));
    }

    @Test
    void reverseWords_whenCalledShouldReverseInputsWordOrder(){
        String input = "Trees are   beautiful";
        String reversedInput = "beautiful are Trees";

        assertEquals(reversedInput, StringManipulation.reverseWords(input));
        assertEquals("", StringManipulation.reverseWords("    "));
        assertEquals("", StringManipulation.reverseWords(""));
        assertEquals("", StringManipulation.reverseWords(null));
    }

    @Test
    void isRotation_whenCalled_shouldIndicateIfCandidateIsRotatedTarget(){
        assertTrue(StringManipulation.isRotation("CDAB", "ABCD"));
        assertFalse(StringManipulation.isRotation("CDAB" + "F", "ABCD"));
        assertFalse(StringManipulation.isRotation("ADBC", "ABCD"));
        assertFalse(StringManipulation.isRotation("", "ABCD"));
        assertFalse(StringManipulation.isRotation(null, "ABCD"));
    }

    @Test
    void removeDuplicates_whenCalled_shouldReturnInputWithoutDuplicateCharacters(){
        assertEquals("Helo!", StringManipulation.removeDuplicates("HHellooo!!"));
        assertEquals("Helo!", StringManipulation.removeDuplicates("Helo!"));
        assertEquals("", StringManipulation.removeDuplicates(""));
        assertEquals("", StringManipulation.removeDuplicates(null));
    }

    @Test
    void maxChar_whenCalled_shouldReturnMaxCountCharacterFromInput(){
        assertEquals('o', StringManipulation.getMax("Hellooo!"));
        assertEquals(' ', StringManipulation.getMax("    "));
        assertEquals('H', StringManipulation.getMax("Helo!"));
        assertThrows(IllegalArgumentException.class, () -> StringManipulation.getMax(""));
        assertThrows(IllegalArgumentException.class, () -> StringManipulation.getMax(null));
    }

    @Test
    void capitalize_whenCalled_shouldCapitalizeEveryWord(){
        assertEquals("Trees Are Beautiful", StringManipulation.capitalize("trees are beautiful"));
        assertEquals("Trees Are Beautiful", StringManipulation.capitalize("tRees arE bEautiful"));
        assertEquals("Trees", StringManipulation.capitalize("trees"));
        assertEquals("T", StringManipulation.capitalize("t"));
        assertEquals("", StringManipulation.capitalize(""));
        assertEquals("", StringManipulation.capitalize(null));
    }

    @Test
    void isAnagram_whenCalled_shouldReturnTrueIfCandidateIsAnagramOfTargetFalseOtherwise(){
        assertTrue(StringManipulation.isAnagram("abcd", "adbc"));
        assertTrue(StringManipulation.isAnagram("abcd", "cadb"));
        assertTrue(StringManipulation.isAnagram("abcd", "abcd"));
        assertFalse(StringManipulation.isAnagram("abcd", "abce"));
        assertFalse(StringManipulation.isAnagram("", "abce"));
        assertFalse(StringManipulation.isAnagram("abce", ""));
        assertFalse(StringManipulation.isAnagram(null, "abce"));
        assertFalse(StringManipulation.isAnagram("abcd", null));
    }

    @Test
    void isPalindrome_whenCalled_shouldReturnTrueIfStringIsPalindromeAndFalseOtherwise(){
        assertTrue(StringManipulation.isPalindrome("abba"));
        assertTrue(StringManipulation.isPalindrome("abcba"));
        assertTrue(StringManipulation.isPalindrome(" ab ba "));
        assertTrue(StringManipulation.isPalindrome("racecar"));

        assertFalse(StringManipulation.isPalindrome("abbag"));
        assertFalse(StringManipulation.isPalindrome(" abba  "));
        assertFalse(StringManipulation.isPalindrome("abbca"));
        assertFalse(StringManipulation.isPalindrome(""));
        assertFalse(StringManipulation.isPalindrome(null));
    }
}
