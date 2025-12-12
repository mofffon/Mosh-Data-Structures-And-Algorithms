package pl.lukaszJaskiewicz.hashMapHashSet;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashMapHashSetExercisesTest {

    @Test
    void findFirstNonRepeating_whenCalledWithNull_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HashMapHashSetExercises.findFirstNonRepeating(null));
    }

    @Test
    void firstNonRepeating_whenCalledWithAStringWithNonAllRepeatingCharacters_shouldReturnTheFindFirstNonRepeatingLetter(){
        assertEquals('g', HashMapHashSetExercises.findFirstNonRepeating("a green apple"));
    }

    @Test
    void findFirstNonRepeating_whenCalledWithAStringWithAllRepeatingCharacters_shouldReturnNull(){
        assertNull(HashMapHashSetExercises.findFirstNonRepeating("hannah"));
    }

    @Test
    void findFirstRepeating_whenCalledWithNull_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HashMapHashSetExercises.findFirstRepeating(null));
    }

    @Test
    void findFirstRepeating_whenCalledWithAStringWithARepeatingCharacter_shouldReturnTheRepeatingCharacter() {
        assertEquals('e', HashMapHashSetExercises.findFirstRepeating("a green apple"));
    }

    @Test
    void findFirstRepeating_whenCalledWithAStringWithANonRepeatingCharacters_shouldReturnTheRepeatingCharacter() {
        assertNull(HashMapHashSetExercises.findFirstRepeating("abcd efgh"));
    }

    @Test
    void findMostRepeated_whenCalledWithValidArgument_shouldReturnFindMostRepeatedInteger() {
        assertEquals(3, HashMapHashSetExercises.findMostRepeated(new int[]{1, 2, 2, 3, 3, 3, 4}));
    }

    @Test
    void findMostRepeated_whenCalledWithArrayOfDistinctIntegers_shouldReturnANumberFromTheArray(){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int result = HashMapHashSetExercises.findMostRepeated(arr);
        assertTrue(Arrays.stream(arr).anyMatch( num -> num == result));
    }

    @Test
    void findMostRepeated_whenCalledWithNull_ShouldThrowNewIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HashMapHashSetExercises.findMostRepeated(null));
    }

    @Test
    void findMostRepeated_whenCalledWithZeroLengthArray_ShouldThrowNewIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HashMapHashSetExercises.findMostRepeated(new int[]{}));
    }

    @Test
    void countPairsOfDiff_whenCalledWithNullAsArrayArgument_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HashMapHashSetExercises.countPairsOfDiff(2, null));
    }

    @Test
    void countPairsOfDiff_whenCalled_shouldReturnCountOfPairsDifferentByK(){
        assertEquals(4, HashMapHashSetExercises.countPairsOfDiff(2, new int[]{1, 7, 5, 9, 2, 12, 3}));
    }

    @Test
    void findTwoSum_whenCalled_shouldReturnFirstPairOfNumbersDifferentByK() {
        assertArrayEquals(new int[]{0, 1}, HashMapHashSetExercises.findTwoSum(9, new int[]{2, 7, 11, 15}));
    }
}