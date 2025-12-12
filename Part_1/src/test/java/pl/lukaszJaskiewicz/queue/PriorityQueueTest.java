package pl.lukaszJaskiewicz.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    FullQueue queue;

    @BeforeEach
    void createPriorityQueue(){
        queue = new PriorityQueue();
    }

    @Test
    void isFull_whenCalled_shouldReturnTrue() {

        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(10);
        queue.enqueue(20);

        assertTrue(queue.isFull());
    }

    @Test
    void isFull_whenCalledOnFullThenHalfFullThenFull_shouldReturnTrue() {

        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(10);
        queue.enqueue(20);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(20);
        queue.enqueue(10);
        queue.enqueue(30);

        assertTrue(queue.isFull());
    }

    @Test
    void isFull_whenCalled_shouldReturnFalse(){
        assertFalse(queue.isFull());

        queue.enqueue(50);
        assertFalse(queue.isFull());

        queue.enqueue(30);
        assertFalse(queue.isFull());

        queue.enqueue(40);
        assertFalse(queue.isFull());

        queue.enqueue(10);
        assertFalse(queue.isFull());

        queue.enqueue(20);

        queue.dequeue();
        assertFalse(queue.isFull());

        queue.dequeue();
        assertFalse(queue.isFull());

        queue.dequeue();
        assertFalse(queue.isFull());

        queue.dequeue();
        assertFalse(queue.isFull());

        queue.dequeue();
        assertFalse(queue.isFull());
    }

    @Test
    void isEmpty_whenCalledOnEmptyQueue_shouldReturnTrue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmpty_whenCalledOnFullThenEmptyQueue_shouldReturnTrue(){
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmpty_whenCalledOnHalfFullThenEmptyQueue_shouldReturnTrue() {
        queue.enqueue(10);
        queue.enqueue(20);

        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test
    void enqueue_whenCalledReturnStringRepresentationOfFiveSortedItems_shouldAddItemAtProperPlaceInQueue() {

        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        assertEquals("[10, 20, 30, 40, 50]", queue.toString());
    }

    @Test
    void enqueue_whenCalledOnFullThanEmptyQueue_shouldQueueBeEmpty() {

        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals("[]", queue.toString());

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals("[10, 20, 30, 40, 50]", queue.toString());
    }

    @Test
    void enqueue_whenCalledOnEmptyThanFullThanEmptyThanFullQueue_shouldQueueBeEmpty() {
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals("[10, 20, 30, 40, 50]", queue.toString());
    }

    @Test
    void enqueue_whenCalledOnFullQueue_shouldThrowIllegalStateException() {

        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        assertThrows(IllegalStateException.class, () -> queue.enqueue(60));
    }

    @Test
    void enqueue_whenCalledOnFullThenHalfFullThenFullQueue_shouldThrowIllegalStateException() {

        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);

        assertThrows(IllegalStateException.class, () -> queue.enqueue(60));
    }

    @Test
    void dequeue_whenCalledOnEmptyQueue_shouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    void dequeue_whenCalledOnFullThenEmptyQueue_shouldThrowIllegalStateException() {
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertThrows(IllegalStateException.class, () -> queue.dequeue());

        queue.enqueue(10);
        queue.enqueue(20);

        queue.dequeue();
        queue.dequeue();

        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    void dequeue_whenCalledOnFullThenEmptyThenHalfFullThenEmpty_shouldThrowIllegalStateException() {
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(20);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }

    @Test
    void dequeue_whenCalledOnFullQueue_shouldRemoveFirstItem() {
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
        assertEquals(50, queue.dequeue());
    }

    @Test
    void dequeue_whenCalledOHalfFullQueue_shouldRemoveFirstItem() {
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(20);
        queue.enqueue(10);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
    }

    @Test
    void testToString_whenCalled_shouldReturnStringRepresentationOfTheQueue() {

        assertEquals("[]", queue.toString());

        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(40);

        assertEquals("[10, 20, 30, 40, 50]", queue.toString());

        queue.dequeue();
        assertEquals("[20, 30, 40, 50]", queue.toString());

        queue.dequeue();
        assertEquals("[30, 40, 50]", queue.toString());

        queue.dequeue();
        assertEquals("[40, 50]", queue.toString());

        queue.dequeue();
        assertEquals("[50]", queue.toString());

        queue.dequeue();
        assertEquals("[]", queue.toString());
    }
}