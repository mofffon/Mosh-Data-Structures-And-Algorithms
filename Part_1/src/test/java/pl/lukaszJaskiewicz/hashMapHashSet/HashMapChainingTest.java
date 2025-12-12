package pl.lukaszJaskiewicz.hashMapHashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapChainingTest {

    HashMapChaining hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapChaining();
    }

    @Test
    void put_whenCalled_shouldAddEntryToHashMap() {

        hashMap.put(0,"a");
        hashMap.put(1,"b");
        hashMap.put(2,"c");
        hashMap.put(3,"d");
        hashMap.put(4,"e");
        hashMap.put(5,"f");
        hashMap.put(6,"g");
        hashMap.put(7,"h");
        hashMap.put(8,"i");
        hashMap.put(9,"j");

        assertEquals("[<0, a>, <5, f>, <1, b>, <6, g>, <2, c>, <7, h>, <3, d>, <8, i>, <4, e>, <9, j>]", hashMap.toString());
    }

    @Test
    void put_whenCalledWithKeyEqualNegativeInteger_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> hashMap.put(-1, "a"));
    }

    @Test
    void put_whenCalledWithValueEqualNull_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> hashMap.put(1, null));
    }

    @Test
    void get_whenCalledWihKeyWhichExistsInHashMap_shouldReturnValue() {

        hashMap.put(0,"a");
        hashMap.put(1,"b");
        hashMap.put(2,"c");
        hashMap.put(3,"d");
        hashMap.put(4,"e");
        hashMap.put(5,"f");
        hashMap.put(6,"g");
        hashMap.put(7,"h");
        hashMap.put(8,"i");
        hashMap.put(9,"j");

        assertEquals("b", hashMap.get(1));
        assertEquals("a", hashMap.get(0));
        assertEquals("g", hashMap.get(6));
        assertEquals("j", hashMap.get(9));
        assertEquals("i", hashMap.get(8));
        assertEquals("c", hashMap.get(2));
        assertEquals("f", hashMap.get(5));
        assertEquals("d", hashMap.get(3));
        assertEquals("h", hashMap.get(7));
        assertEquals("e", hashMap.get(4));
    }

    @Test
    void get_whenCalledWithKeyWhichIsNegative_shouldReturnIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> hashMap.get(-1));
    }

    @Test
    void get_whenCalledWithKeyWhichDoesNotExistInHashMap_shouldReturnNull() {
        hashMap.put(0,"a");
        hashMap.put(1,"b");
        hashMap.put(2,"c");
        hashMap.put(3,"d");
        hashMap.put(4,"e");
        hashMap.put(5,"f");
        hashMap.put(6,"g");
        hashMap.put(7,"h");
        hashMap.put(8,"i");
        hashMap.put(9,"j");

        assertNull(hashMap.get(10));
    }

    @Test
    void remove_whenCalledWithKeyWhichExistsInHashMap_shouldReturnValue() {
        hashMap.put(0,"a");
        hashMap.put(1,"b");
        hashMap.put(2,"c");
        hashMap.put(3,"d");
        hashMap.put(4,"e");
        hashMap.put(5,"f");
        hashMap.put(6,"g");
        hashMap.put(7,"h");
        hashMap.put(8,"i");
        hashMap.put(9,"j");

        assertEquals("b", hashMap.remove(1));
        assertEquals("a", hashMap.remove(0));
        assertEquals("g", hashMap.remove(6));
        assertEquals("j", hashMap.remove(9));
        assertEquals("i", hashMap.remove(8));
        assertEquals("c", hashMap.remove(2));
        assertEquals("f", hashMap.remove(5));
        assertEquals("d", hashMap.remove(3));
        assertEquals("h", hashMap.remove(7));
        assertEquals("e", hashMap.remove(4));
    }

    @Test
    void remove_whenCalledOnHashMapWihNoCorrectKey_shouldThrowIllegalArgumentException() {

        hashMap.put(1,"b");
        hashMap.put(2,"c");

        assertThrows(IllegalArgumentException.class, () -> hashMap.remove(0));
        assertThrows(IllegalArgumentException.class, () -> hashMap.remove(3));
    }
}