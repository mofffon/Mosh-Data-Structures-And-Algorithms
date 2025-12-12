package pl.lukaszJaskiewicz.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackOfTwoQueuesTest {


    @Test
    void push_whenCalled_shouldAddedItem(){

        StackOfTwoQueues stack = new StackOfTwoQueues();

        stack.push(10);
        Assertions.assertEquals(10, stack.peek());

        stack.push(20);
        Assertions.assertEquals(20, stack.peek());

        stack.push(30);
        Assertions.assertEquals(30, stack.peek());
    }

    @Test
    void pop_whenCalled_shouldThrowIllegalStateException() {
        StackOfTwoQueues stack = new StackOfTwoQueues();

        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void pop_whenCalled_shouldReturnThePushedItem(){

        StackOfTwoQueues stack = new StackOfTwoQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        Assertions.assertEquals(40, stack.pop());
        Assertions.assertEquals(30, stack.pop());
        Assertions.assertEquals(20, stack.pop());
        Assertions.assertEquals(10, stack.pop());
    }

    @Test
    void peek_whenCalled_shouldThrowIllegalStateException(){
        StackOfTwoQueues stack = new StackOfTwoQueues();
        assertThrows(IllegalStateException.class, stack::peek);

        stack.push(10);
        stack.pop();

        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void peek_whenCalled_shouldReturnPushedItem() {
        StackOfTwoQueues stack = new StackOfTwoQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        Assertions.assertEquals(40, stack.peek());
        stack.pop();

        Assertions.assertEquals(30, stack.peek());
        stack.pop();

        Assertions.assertEquals(20, stack.peek());
        stack.pop();

        Assertions.assertEquals(10, stack.peek());
    }

    @Test
    void isEmpty_whenCalled_shouldReturnTrue(){
        StackOfTwoQueues stack = new StackOfTwoQueues();

        Assertions.assertTrue(stack.isEmpty());

        stack.push(10);
        stack.pop();

        Assertions.assertTrue(stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.pop();
        stack.pop();

        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void isEmpty_whenCalled_shouldReturnFalse(){
        StackOfTwoQueues stack = new StackOfTwoQueues();

        stack.push(10);
        Assertions.assertFalse(stack.isEmpty());

        stack.push(20);
        Assertions.assertFalse(stack.isEmpty());

        stack.push(30);
        Assertions.assertFalse(stack.isEmpty());

        stack.pop();
        stack.pop();
        Assertions.assertFalse(stack.isEmpty());
    }
}