package pl.lukaszjaskiewicz.sortingAlgorithms.selectionSort;

import org.junit.jupiter.api.Test;
import pl.lukaszjaskiewicz.sortingAlgorithms.selectionSort.SelectionSort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sort_whenCalled_shouldSortInputArray() {
        int[] input = {7,3,1,4,6,2,3};

        SelectionSort.sort(input);
        assertEquals("[1, 2, 3, 3, 4, 6, 7]", Arrays.toString(input));
    }
}