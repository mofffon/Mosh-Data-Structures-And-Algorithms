package pl.lukaszjaskiewicz.sortingAlgorithms.bubbleSort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @org.junit.jupiter.api.Test
    void sort_whenCalled_shouldSortInputArray() {
        int[] input = {7,3,1,4,6,2,3};

        BubbleSort.sort(input);
        assertEquals("[1, 2, 3, 3, 4, 6, 7]", Arrays.toString(input));
    }
}