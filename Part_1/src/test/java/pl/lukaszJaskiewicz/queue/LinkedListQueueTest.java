package pl.lukaszJaskiewicz.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {

    Queue arrayQueue;

    @BeforeEach
    void beforeEach(){
        arrayQueue = new LinkedListQueue();
    }

    @Test
    void enqueue_whenCalled_shouldAddItemToQueue() {

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);

        assertEquals("[10, 20, 30, 40]", arrayQueue.toString());
    }

    @Test
    void dequeue_whenCalled_shouldDequeueFirstItemInQueue() {

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);

        assertEquals(10, arrayQueue.dequeue());
        assertEquals(20, arrayQueue.dequeue());
        assertEquals(30, arrayQueue.dequeue());
        assertEquals(40, arrayQueue.dequeue());
        assertEquals(50, arrayQueue.dequeue());
    }

    @Test
    void dequeue_whenCalledOnEmptyQueue_shouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class, arrayQueue::dequeue);
    }

    @Test
    void dequeue_whenCalledOnPartiallyFilledThenEmptiedQueue_shouldThrowIllegalStateException(){
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.dequeue();
        arrayQueue.dequeue();

        assertThrows(IllegalStateException.class, arrayQueue::dequeue);
    }

    @Test
    void dequeue_whenCalledOnFullThenEmptyQueue_shouldThrowIllegalStateException(){

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();

        assertThrows(IllegalStateException.class, arrayQueue::dequeue);
    }

    @Test
    void peek_whenCalledOnEmptyQueue_shouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class, arrayQueue::peek);
    }

    @Test
    void peek_whenCalledOnPartiallyFilledThenEmptiedQueue_shouldThrowIllegalStateException() {

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.dequeue();
        arrayQueue.dequeue();

        assertThrows(IllegalStateException.class, arrayQueue::peek);
    }

    @Test
    void peek_whenCalledOnFullThenEmptyQueue_shouldThrowIllegalStateException(){
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();

        assertThrows(IllegalStateException.class, arrayQueue::peek);
    }

    @Test
    void peek_whenCalled_shouldReturnFirstItemInTheQueue() {

        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);

        assertEquals(10, arrayQueue.peek());
        arrayQueue.dequeue();
        assertEquals(20, arrayQueue.peek());
        arrayQueue.dequeue();
        assertEquals(30, arrayQueue.peek());
        arrayQueue.dequeue();
        assertEquals(40, arrayQueue.peek());
        arrayQueue.dequeue();
    }

    @Test
    void isEmpty_whenCalledOnEmptyQueue_shouldReturnTrue() {

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void isEmpty_whenCalledOnFilledThenEmptyQueue_shouldReturnTrue() {
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);

        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();

        assertTrue(arrayQueue.isEmpty());
    }
}