package pl.lukaszJaskiewicz.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void reverse_whenCalled_shouldReturnReversedString() {

        String input = "abcd";

        assertEquals("dcba", Stack.reverse(input));
    }

    @Test
    void reverse_whenCalled_shouldThrowIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> Stack.reverse(null));
    }

    @Test
    void isBalanced_whenCalled_shouldReturnTrue() {

        assertTrue(Stack.isBalanced("(([1] + <2>))[a]"));
        assertTrue(Stack.isBalanced("1 + 1"));
    }

    @Test
    void isBalanced_whenCalled_shouldReturnFalse() {

        assertFalse(Stack.isBalanced(null));
        assertFalse(Stack.isBalanced("(([1> + <2>))[a]"));
        assertFalse(Stack.isBalanced("<1> + (8"));
        assertFalse(Stack.isBalanced("()1 + 2("));
    }

    @Test
    void Stack_whenCalled_shouldThrowIllegalArgumentException(){

        assertThrows(IllegalArgumentException.class, () -> new Stack(0));
        assertThrows(IllegalArgumentException.class, () -> new Stack(-1));
    }

    @Test
    void push_whenCalled_shouldAddedItem(){

        Stack stack = new Stack(5);

        stack.push(10);
        assertEquals(10, stack.peek());

        stack.push(20);
        assertEquals(20, stack.peek());

        stack.push(30);
        assertEquals(30, stack.peek());
    }

    @Test
    void push_whenCalled_ShouldThrowStackOverflowError() {

        Stack stack = new Stack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertThrows(StackOverflowError.class, () -> stack.push(40));
    }

    @Test
    void pop_whenCalled_shouldThrowIllegalStateException() {
        Stack stack = new Stack(3);

        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void pop_whenCalled_shouldReturnThePushedItem(){

        Stack stack = new Stack(4);

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
        Stack stack = new Stack(4);
        assertThrows(IllegalStateException.class, stack::peek);

        stack.push(10);
        stack.pop();

        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void peek_whenCalled_shouldReturnPushedItem() {
        Stack stack = new Stack(4);

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
        Stack stack = new Stack(3);

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
        Stack stack = new Stack(3);

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