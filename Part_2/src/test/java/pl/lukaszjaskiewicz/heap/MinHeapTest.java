package pl.lukaszjaskiewicz.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    MinHeap heap;

    @BeforeEach
    void setUp(){
        heap = new MinHeap();
    }

    @Test
    void isFull_whenCalledOnNotFullHeap_shouldReturnFalse() {

        heap = new MinHeap(3);

        assertFalse(heap.isFull());
        heap.insert(1,"a");
        assertFalse(heap.isFull());
        heap.insert(1,"a");
        assertFalse(heap.isFull());
    }

    @Test
    void isFull_whenCalledOnFullHeap_shouldReturnTrue(){
        heap = new MinHeap(3);

        heap.insert(1,"a");
        heap.insert(2,"b");
        heap.insert(3,"c");

        assertTrue(heap.isFull());

        heap.remove();
        heap.remove();
        heap.remove();

        heap.insert(1,"a");
        heap.insert(2,"b");
        heap.insert(3,"c");

        assertTrue(heap.isFull());
    }

    @Test
    void isEmpty_whenCalledOnEmptyHeap_shouldReturnTrue(){
        assertTrue(heap.isEmpty());

        heap.insert(1,"a");
        heap.insert(2,"b");
        heap.insert(3,"c");

        heap.remove();
        heap.remove();
        heap.remove();

        assertTrue(heap.isEmpty());
    }

    @Test
    void insert_whenCalled_shouldAddItemToHeap() {

        assertEquals(0, heap.getCount());

        heap.insert(1, "a");
        heap.insert(2, "b");
        heap.insert(3, "c");
        heap.insert(4, "d");

        assertEquals(4, heap.getCount());
    }

    @Test
    void remove() {

        heap.insert(5, "e");
        heap.insert(3, "c");
        heap.insert(4, "d");
        heap.insert(1, "a");
        heap.insert(2, "b");

        assertEquals("a", heap.remove());
        assertEquals("b", heap.remove());
        assertEquals("c", heap.remove());
        assertEquals("d", heap.remove());
        assertEquals("e", heap.remove());

    }
}