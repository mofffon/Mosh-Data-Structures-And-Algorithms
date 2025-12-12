package pl.lukaszJaskiewicz.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueReverserTest {

    @Test
    void reverse_whenCalled_shouldReverseEntireQueue() {

        ArrayQueue queue = new ArrayQueue(5);

        QueueReverser.reverse(queue);

        assertEquals("[]", queue.toString());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        QueueReverser.reverse(queue);
        assertEquals("[40, 30, 20, 10]", queue.toString());

        QueueReverser.reverse(queue);
        queue.enqueue(50);

        QueueReverser.reverse(queue);
        assertEquals("[50, 40, 30, 20, 10]", queue.toString());
    }

    @Test
    void reverse_whenCalled_shouldReverseAPortionOfKItemsInQueue() {

        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        QueueReverser.reverse(0, queue);
        assertEquals("[10, 20, 30, 40, 50]", queue.toString());

        QueueReverser.reverse(1, queue);
        assertEquals("[10, 20, 30, 40, 50]", queue.toString());

        QueueReverser.reverse(2, queue);
        assertEquals("[20, 10, 30, 40, 50]", queue.toString());

        QueueReverser.reverse(3, queue);
        assertEquals("[30, 10, 20, 40, 50]", queue.toString());

        QueueReverser.reverse(4, queue);
        assertEquals("[40, 20, 10, 30, 50]", queue.toString());

        QueueReverser.reverse(5, queue);
        assertEquals("[50, 30, 10, 20, 40]", queue.toString());
    }
}