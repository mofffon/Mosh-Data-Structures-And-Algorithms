package pl.lukaszjaskiewicz.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPriorityQueueTest {

    MinPriorityQueue queue;

    @BeforeEach
    void setUp(){
        queue = new MinPriorityQueue();
    }

    @Test
    void isEmpty_whenCalledOnEmptyQueue_shouldReturnTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmpty_whenCalledOnNonEmptyQueue_shouldReturnFalse(){
        queue.enqueue(1, "Alicja");

        assertFalse(queue.isEmpty());
    }

    @Test
    void enqueue() {
        queue.enqueue(1, "Alicja");

        assertFalse(queue.isEmpty());
    }

    @Test
    void dequeue() {
        queue.enqueue(3, "Cezary");
        queue.enqueue(1, "Alicja");
        queue.enqueue(2, "Bartek");

        assertEquals("Alicja", queue.dequeue());
        assertEquals("Bartek", queue.dequeue());
        assertEquals("Cezary", queue.dequeue());
    }
}