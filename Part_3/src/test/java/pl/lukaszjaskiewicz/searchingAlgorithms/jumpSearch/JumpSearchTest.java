package pl.lukaszjaskiewicz.searchingAlgorithms.jumpSearch;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class JumpSearchTest {

    @org.junit.jupiter.api.Test
    void search_whenCalled_shouldTryToFindTargetNumberInInput(){
        int[] input = {7,3,1,4,6,2,3};

        Arrays.sort(input);

        assertTrue(JumpSearch.search(4, input) > -1);
        assertEquals(-1, JumpSearch.search(5, input));
    }
}
