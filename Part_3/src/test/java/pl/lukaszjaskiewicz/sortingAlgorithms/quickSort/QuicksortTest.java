package pl.lukaszjaskiewicz.sortingAlgorithms.quickSort;

import org.junit.jupiter.api.Test;
import pl.lukaszjaskiewicz.sortingAlgorithms.quickSort.QuickSort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuicksortTest {

    @Test
    void sort_whenCalled_shouldSortInputArray(){
        int[] input = {7,3,1,4,6,2,3};

        QuickSort.sort(input);
        assertEquals("[1, 2, 3, 3, 4, 6, 7]", Arrays.toString(input));
    }
}