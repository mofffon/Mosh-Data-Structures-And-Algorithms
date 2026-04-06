package pl.lukaszjaskiewicz.sortingAlgorithms.bucketSort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BucketSortTest {

    @org.junit.jupiter.api.Test
    void sort_whenCalled_shouldSortInputArray() {
        int[] input = {7,3,1,4,6,2,3};

        BucketSort.sort(input, 3);
        assertEquals("[1, 2, 3, 3, 4, 6, 7]", Arrays.toString(input));
    }
}
