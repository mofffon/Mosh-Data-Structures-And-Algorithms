package pl.lukaszJaskiewicz.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackLinkedListImplTest {
    @Test
    void push_whenCalled_shouldAddedItem(){

        StackLinkedListImpl stack = new StackLinkedListImpl();

        stack.push(10);
        assertEquals(10, stack.peek());

        stack.push(20);
        assertEquals(20, stack.peek());

        stack.push(30);
        assertEquals(30, stack.peek());
    }

    @Test
    void pop_whenCalled_shouldThrowIllegalStateException() {
        StackLinkedListImpl stack = new StackLinkedListImpl();

        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void pop_whenCalled_shouldReturnThePushedItem(){

        StackLinkedListImpl stack = new StackLinkedListImpl();

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
        StackLinkedListImpl stack = new StackLinkedListImpl();
        assertThrows(IllegalStateException.class, stack::peek);

        stack.push(10);
        stack.pop();

        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void peek_whenCalled_shouldReturnPushedItem() {
        StackLinkedListImpl stack = new StackLinkedListImpl();

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
    void isEmpty_whenCalled_shouldReturnTrue(){
        StackLinkedListImpl stack = new StackLinkedListImpl();

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
    void isEmpty_whenCalled_shouldReturnFalse(){
        StackLinkedListImpl stack = new StackLinkedListImpl();

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
}