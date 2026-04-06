package pl.lukaszjaskiewicz.searchingAlgorithms.linearSearch;

import static org.junit.jupiter.api.Assertions.*;

public class LinearSearchTest {

    @org.junit.jupiter.api.Test
    void search_whenCalled_shouldTryToFindTargetNumberInInput(){
        int[] input = {7,3,1,4,6,2,3};

        assertEquals(3, LinearSearch.search(4, input));
        assertEquals(-1, LinearSearch.search(10, input));
    }
}
