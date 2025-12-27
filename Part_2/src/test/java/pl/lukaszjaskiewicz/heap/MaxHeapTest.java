package pl.lukaszjaskiewicz.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    MaxHeap maxHeap;

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap();
    }

    @Test
    void insert_whenCalledOnAEmptyHeap_shouldAddNodeToHeap() {

        int[] values = new int[]{15, 10, 3, 8, 12, 9, 4, 1, 24};

        for(int value: values){
            maxHeap.insert(value);
        }

        assertEquals("[ 24  15  9  12  10  3  4  1  8 ]", maxHeap.toString());
    }

    @Test
    void remove_whenCalledOnNonEmptyHeap_shouldReturnMaxRootValue() {
        int[] values = new int[]{15, 10, 3, 8, 12, 9, 4, 1, 24};

        for(int value: values){
            maxHeap.insert(value);
        }

        assertEquals(24, maxHeap.remove());
        assertEquals(15, maxHeap.remove());
    }

    @Test
    void heapify_whenCalled_shouldReturnAHeapOfAnArray(){
        int[] values = new int[]{5,3,8,4,1,2};

        for(int value: values){
            maxHeap.insert(value);
        }

        String str = maxHeap.toString();

        int[] heapArr = new int[values.length];
        str = str.substring(2);
        str = str.substring(0, str.length() - 2);
        String[] splitStr = str.split("  ");

        for(int i= 0; i < splitStr.length; i++) {
            heapArr[i] = Integer.parseInt(splitStr[i]);
        }

        MaxHeap.heapify(values);
        assertArrayEquals(heapArr, values);
    }

    @Test
    void kthLargest_whenCalledOnArray_shouldReturnTheKthLargestItem(){
        int[] values = new int[]{5,3,8,4,1,2};

        assertEquals(8, MaxHeap.getKthLargest(1, values));
        assertEquals(5, MaxHeap.getKthLargest(2, values));
        assertEquals(4, MaxHeap.getKthLargest(3, values));
        assertEquals(3, MaxHeap.getKthLargest(4, values));
        assertEquals(2, MaxHeap.getKthLargest(5, values));
        assertEquals(1, MaxHeap.getKthLargest(6, values));
    }

    @Test
    void isMaxHeap_whenCalledWithHeapifiedArray_shouldReturnTrue(){
        int[] values = new int[]{8,4,5,3,1,2};

        assertTrue(MaxHeap.isMaxHeap(values));
    }

    @Test
    void isMaxHeap_whenCalledWithnonHeapifiedArray_shouldReturnFalse(){
        int[] values = new int[]{8,4,3,5,1,2};

        assertFalse(MaxHeap.isMaxHeap(values));
    }
}