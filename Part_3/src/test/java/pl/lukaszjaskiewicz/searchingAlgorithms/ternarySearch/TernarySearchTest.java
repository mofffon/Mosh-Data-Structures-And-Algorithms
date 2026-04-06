package pl.lukaszjaskiewicz.searchingAlgorithms.ternarySearch;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TernarySearchTest {

    @org.junit.jupiter.api.Test
    void search_whenCalled_shouldTryToFindTargetNumberInInput(){
        int[] input = {7,3,1,4,6,2,3};

        Arrays.sort(input);

        assertTrue(TernarySearch.search(4, input) > -1);
        assertEquals(-1, TernarySearch.search(10, input));
    }
}
