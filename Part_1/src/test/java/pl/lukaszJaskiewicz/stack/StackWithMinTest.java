package pl.lukaszJaskiewicz.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackWithMinTest {
    @Test
    void push_whenCalled_shouldAddedItem() {

        StackWithMin stack = new StackWithMin(3);

        stack.push(10);
        assertEquals(10, stack.peek());

        stack.push(20);
        assertEquals(20, stack.peek());

        stack.push(30);
        assertEquals(30, stack.peek());
    }

    @Test
    void pop_whenCalled_shouldThrowIllegalStateException() {
        StackWithMin stack = new StackWithMin(3);

        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void pop_whenCalled_shouldReturnThePushedItem() {

        StackWithMin stack = new StackWithMin(4);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(40, stack.pop());
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void peek_whenCalled_shouldThrowIllegalStateException(){
        StackWithMin stack = new StackWithMin(1);
        assertThrows(IllegalStateException.class, stack::peek);

        stack.push(10);
        stack.pop();

        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void peek_whenCalled_shouldReturnPushedItem() {
        StackWithMin stack = new StackWithMin(4);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(40, stack.peek());
        stack.pop();

        assertEquals(30, stack.peek());
        stack.pop();

        assertEquals(20, stack.peek());
        stack.pop();

        assertEquals(10, stack.peek());
    }

    @Test
    void isEmpty_whenCalled_shouldReturnTrue() {
        StackWithMin stack = new StackWithMin(3);

        assertTrue(stack.isEmpty());

        stack.push(10);
        stack.pop();

        assertTrue(stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.pop();
        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmpty_whenCalled_shouldReturnFalse() {
        StackWithMin stack = new StackWithMin(3);

        stack.push(10);
        assertFalse(stack.isEmpty());

        stack.push(20);
        assertFalse(stack.isEmpty());

        stack.push(30);
        assertFalse(stack.isEmpty());

        stack.pop();
        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    void min_whenCalled_shouldThrowIllegalStateException(){
        StackWithMin stack = new StackWithMin(4);

        assertThrows(IllegalStateException.class, stack::min);
    }

    @Test
    void min_whenCalled_shouldReturnMinValue() {
        StackWithMin stack = new StackWithMin(4);

        stack.push(40);
        stack.push(20);
        stack.push(10);
        stack.push(30);

        assertEquals(10, stack.min());

        stack.pop();
        stack.pop();

        assertEquals(20, stack.min());
        stack.pop();
        assertEquals(40, stack.min());

    }
}