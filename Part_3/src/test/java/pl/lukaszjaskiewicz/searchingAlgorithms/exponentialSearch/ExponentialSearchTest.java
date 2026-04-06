package pl.lukaszjaskiewicz.searchingAlgorithms.exponentialSearch;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ExponentialSearchTest {

    @org.junit.jupiter.api.Test
    void search_whenCalled_shouldTryToFindTargetNumberInInput(){
        int[] input = {7,3,1,4,6,2,3};

        Arrays.sort(input);

        assertTrue(ExponentialSearch.search(4, input) > -1);
        assertEquals(-1, ExponentialSearch.search(5, input));
    }
}
