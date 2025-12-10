package pl.lukaszJaskiewicz.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList list;

    @BeforeEach
    void prepare() {
        list = new LinkedList();
    }

    @Test
    void addFirst_whenCalled_shouldAddItemAtListStart() {

        assertEquals(list.toString(), "[]");

        list.addFirst(30);
        assertEquals(list.toString(), "[30]");

        list.addFirst(20);
        assertEquals(list.toString(), "[20, 30]");

        list.addFirst(10);
        assertEquals(list.toString(), "[10, 20, 30]");
    }

    @Test
    void addLast_whenCalled_shouldAddItemAtListEnd() {

        list.addLast(10);
        assertEquals(list.toString(), "[10]");

        list.addLast(20);
        assertEquals(list.toString(), "[10, 20]");

        list.addLast(30);
        assertEquals(list.toString(), "[10, 20, 30]");
    }

    @Test
    void deleteFirst_whenCalled_shouldDeleteFirstItemFromList() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(list.toString(), "[10, 20, 30]");

        list.deleteFirst();
        assertEquals(list.toString(), "[20, 30]");

        list.deleteFirst();
        assertEquals(list.toString(), "[30]");

        list.deleteFirst();
        assertEquals(list.toString(), "[]");


    }

    @Test
    void deleteFirst_whenCalled_shouldThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, list::deleteFirst);
    }

    @Test
    void deleteLast_whenCalled_shouldDeleteLastItemFromList(){
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.deleteLast();
        assertEquals(list.toString(), "[10, 20]");

        list.deleteLast();
        assertEquals(list.toString(), "[10]");

        list.deleteLast();
        assertEquals(list.toString(), "[]");
    }

    @Test
    void deleteLast_whenCalled_shouldThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, list::deleteLast);
    }
    
    @Test
    void indexOf_whenCalled_shouldReturnIndexOfFirstPresentItem() {
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);

        assertEquals(list.indexOf(10), 0);
        assertEquals(list.indexOf(20), 1);
        assertEquals(list.indexOf(30), 2);
        assertEquals(list.indexOf(0), -1);
        assertEquals(list.indexOf(40), -1);
    }

    @Test
    public void contains_whenCalled_shouldReturnTrue() {
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertTrue(list.contains(30));

        assertFalse(list.contains(0));
        assertFalse(list.contains(40));
    }

    @Test
    public void toArray_whenCalled_shouldReturnArrayOfList(){
        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);

        assertArrayEquals(list.toArray(), new int[]{10, 20, 30});

        list.deleteLast();
        assertArrayEquals(list.toArray(), new int[]{10, 20});

        list.deleteFirst();
        assertArrayEquals(list.toArray(), new int[]{20});

        list.deleteFirst();
        assertArrayEquals(list.toArray(), new int[]{});
    }

    @Test
    public void reverse_whenCalled_shouldReverseList() {

        list.addLast(10);

        list.reverse();
        assertArrayEquals(list.toArray(), new int[] {10});

        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        list.reverse();

        assertArrayEquals(list.toArray(), new int[] {50, 40, 30, 20, 10});
    }

    @Test
    public void getKthFromTheEnd_whenCalled_shouldReturnKthNodeFromTheEnd() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        assertEquals(10, list.getKthFromTheEnd(5));
        assertEquals(20, list.getKthFromTheEnd(4));
        assertEquals(30, list.getKthFromTheEnd(3));
        assertEquals(40, list.getKthFromTheEnd(2));
        assertEquals(50, list.getKthFromTheEnd(1));
        assertEquals(50, list.getKthFromTheEnd(0));
        assertEquals(50, list.getKthFromTheEnd(-1));
    }

    @Test
    public void getKthFromTheEnd_whenCalled_shouldThrowArgumentException() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        assertThrows(IllegalArgumentException.class, () -> list.getKthFromTheEnd(6));
    }

    @Test
    public void getKthFromTheEnd_whenCalled_shouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> list.getKthFromTheEnd(1));
    }

    @Test
    public void getMiddle_whenCalled_shouldReturnEmptyArray() {
        assertArrayEquals(new Integer[] {}, list.getMiddle());
    }

    @Test
    public void getMiddle_whenCalled_shouldReturnFirstItem() {
        list.addLast(10);

        assertArrayEquals(new Integer[] {10}, list.getMiddle());
    }

    @Test
    public void getMiddle_whenCalled_shouldReturnFirstAndSecondItem() {

        list.addLast(10);
        list.addLast(20);

        assertArrayEquals(new Integer[]{ 10, 20 }, list.getMiddle());
    }

    @Test
    public void getMiddle_whenCalled_shouldReturnSingleMiddleItem(){
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        assertArrayEquals(new Integer[] {30}, list.getMiddle());
    }

    @Test
    public void getMiddle_whenCalled_shouldReturnPairOfMiddleItems(){
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);

        assertArrayEquals(new Integer[] { 30, 40 }, list.getMiddle());
    }

    @Test
    public void hasLoop_whenCalled_returnsTrue(){

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);

        list.addLoop(5, 2);

        assertTrue(list.hasLoop());
    }

    @Test
    public void hasLoop_whenCalled_returnFalse(){
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);

        assertFalse(list.hasLoop());
    }

    @Test
    public void hasLoop_whenCalled_throwsException() {

        assertThrows(IllegalStateException.class, () -> list.addLoop(2,1));

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        assertThrows(IllegalArgumentException.class, () -> list.addLoop(-1,1));
        assertThrows(IllegalArgumentException.class, () -> list.addLoop(2,-1));

        assertThrows(IllegalArgumentException.class, () -> list.addLoop(1, 2));

        assertThrows(IllegalArgumentException.class, () -> list.addLoop(4,1));
    }
}