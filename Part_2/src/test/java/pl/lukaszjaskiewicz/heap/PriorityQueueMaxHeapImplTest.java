package pl.lukaszjaskiewicz.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueMaxHeapImplTest {

    private PriorityQueueHeapImpl queue;

    @BeforeEach
    void setUp(){
        queue = new PriorityQueueHeapImpl();
    }

    @Test
    void enqueue_whenCalled_shouldAddItemToQueue() {
        queue.enqueue(6);
        queue.enqueue(1);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(4);
        queue.enqueue(7);
        queue.enqueue(9);

        assertEquals("[ 10  8  9  1  4  6  7 ]", queue.toString());
    }

    @Test
    void dequeue_whenCalledOnEmptyQueue_shouldThrowIllegalStateException(){
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    void dequeue_whenCalledOnNonEmptyQueue_shouldReturnTheFirstItem() {

        int[] items = new int[]{15, 10, 3, 8, 12, 9, 4, 1, 24};

        for(int item: items){
            queue.enqueue(item);
        }

        int[] result = new int[items.length];

        for(int i =0; i < items.length; i++){
            result[i] = queue.dequeue();
        }

        assertArrayEquals(new int[]{24, 15, 12, 10, 9, 8, 4, 3, 1}, result);
    }

    @Test
    void isEmpty_whenCalledOnEmptyQueue_returnsTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmpty_whenCalledOnNonEmptyQueue_returnsFalse(){

        queue.enqueue(1);

        assertFalse(queue.isEmpty());
    }
}