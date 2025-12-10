package pl.lukaszJaskiewicz.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoStacksOneArrayTest {

    TwoStacksOneArray stacks;

    @BeforeEach
    void setUp(){
        stacks = new TwoStacksOneArray();
    }

    @Test
    void is1Empty_whenCalledOnEmptyStack1_shouldReturnTrue() {

        assertTrue(stacks.is1Empty());

        stacks.push2(10);
        stacks.push2(20);
        stacks.push2(30);
        stacks.push2(40);
        stacks.push2(50);
        stacks.push2(60);

        assertTrue(stacks.is1Empty());
    }

    @Test
    void is1Empty_whenCalledOnNonEmptyStack1_shouldReturnFalse() {

        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);

        assertFalse(stacks.is1Empty());

        stacks.pop1();
        stacks.pop1();

        assertFalse(stacks.is1Empty());
    }

    @Test
    void is2Empty_whenCalledOnEmptyStack2_shouldReturnTrue() {

        assertTrue(stacks.is2Empty());

        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        stacks.push1(40);
        stacks.push1(50);
        stacks.push1(60);

        assertTrue(stacks.is2Empty());
    }

    @Test
    void is2Empty_whenCalledOnNonEmptyStack2_shouldReturnFalse() {

        stacks.push2(10);
        stacks.push2(20);
        stacks.push2(30);

        assertFalse(stacks.is2Empty());

        stacks.pop2();
        stacks.pop2();

        assertFalse(stacks.is2Empty());
    }

    @Test
    void is1Full_whenCalledOnAStackWithFreeSpace_shouldReturnFalse() {

        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);

        stacks.push2(40);
        stacks.push2(50);
        stacks.push2(60);

        assertFalse(stacks.is1Full());
    }

    @Test
    void is1Full_whenCalledOnAStackWithNoFreeSpace_shouldReturnTrue(){

        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        stacks.push1(40);
        stacks.push1(50);
        stacks.push1(60);
        stacks.push1(70);
        stacks.push1(80);
        stacks.push1(90);
        stacks.push1(100);

        assertTrue(stacks.is1Full());
    }

    @Test
    void is1Full_whenCalledOnAFullStacksFromBothSides_shouldReturnTrue() {
        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        stacks.push1(40);
        stacks.push1(50);

        stacks.push2(60);
        stacks.push2(70);
        stacks.push2(80);
        stacks.push2(90);
        stacks.push2(100);

        assertTrue(stacks.is1Full());
    }

    @Test
    void is2Full_whenCalledOnAStackWithNoFreeSpace_shouldReturnTrue() {
        stacks.push2(10);
        stacks.push2(20);
        stacks.push2(30);
        stacks.push2(40);
        stacks.push2(50);
        stacks.push2(60);
        stacks.push2(70);
        stacks.push2(80);
        stacks.push2(90);
        stacks.push2(100);

        assertTrue(stacks.is2Full());
    }

    @Test
    void push1_whenCalledOnEmptyStack_shouldAddItemToStack1() {
        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        stacks.push1(40);
        stacks.push1(50);

        assertEquals("left = [10, 20, 30, 40, 50]\nright = []", stacks.toString());
    }

    @Test
    void push1_whenCalledOnFullStack_shouldThrowIllegalStateException(){
        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        stacks.push1(40);
        stacks.push1(50);
        stacks.push1(60);

        stacks.push2(70);
        stacks.push2(80);
        stacks.push2(90);
        stacks.push2(100);

        assertThrows(IllegalStateException.class, () -> stacks.push1(110));
    }

    @Test
    void pop1_whenCalledOnEmptyStack_shouldThrowNewIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> stacks.pop1());
    }

    @Test
    void pop1_whenCalledOnNonEmptyStack_shouldReturnLastItem() {
        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        stacks.push1(40);
        stacks.push1(50);
        stacks.push1(60);

        stacks.push2(70);
        stacks.push2(80);
        stacks.push2(90);
        stacks.push2(100);

        assertEquals(60, stacks.pop1());
        assertEquals(50, stacks.pop1());
        assertEquals(40, stacks.pop1());
        assertEquals(30, stacks.pop1());
        assertEquals(20, stacks.pop1());
        assertEquals(10, stacks.pop1());
    }

    @Test
    void push2_whenCalledOnEmptyStack_shouldAddItemToStack2() {
        stacks.push2(10);
        stacks.push2(20);
        stacks.push2(30);
        stacks.push2(40);
        stacks.push2(50);

        assertEquals("left = []\nright = [10, 20, 30, 40, 50]", stacks.toString());
    }

    @Test
    void push2_whenCalledOnFullStack_shouldThrowIllegalStateException(){
        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        stacks.push1(40);
        stacks.push1(50);
        stacks.push1(60);

        stacks.push2(70);
        stacks.push2(80);
        stacks.push2(90);
        stacks.push2(100);

        assertThrows(IllegalStateException.class, () -> stacks.push2(110));
    }

    @Test
    void pop2_whenCalledOnEmptyStack_shouldThrowNewIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> stacks.pop2());
    }

    @Test
    void pop2_whenCalledOnNonEmptyStack_shouldReturnLastItem() {
        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        stacks.push1(40);
        stacks.push1(50);
        stacks.push1(60);

        stacks.push2(70);
        stacks.push2(80);
        stacks.push2(90);
        stacks.push2(100);

        assertEquals(100, stacks.pop2());
        assertEquals(90, stacks.pop2());
        assertEquals(80, stacks.pop2());
        assertEquals(70, stacks.pop2());
    }

    @Test
    void testToString() {

        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);

        stacks.push2(40);
        stacks.push2(50);
        stacks.push2(60);

        System.out.println(stacks);
    }
}