package pl.lukaszjaskiewicz.searchingAlgorithms.binarySearch;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @org.junit.jupiter.api.Test
    void searchRecursive_whenCalled_shouldTryToFindTargetNumberInInput(){
        int[] input = {7,3,1,4,6,2,3};

        Arrays.sort(input);

        assertTrue(BinarySearch.searchRecursive(4, input) > -1);
        assertEquals(-1, BinarySearch.searchRecursive(10, input));
    }

    @org.junit.jupiter.api.Test
    void searchIterative_whenCalled_shouldTryToFindTargetNumberInInput(){
        int[] input = {7,3,1,4,6,2,3};

        Arrays.sort(input);

        assertTrue(BinarySearch.searchIterative(4, input) > -1);
        assertEquals(-1, BinarySearch.searchIterative(10, input));
    }
}
