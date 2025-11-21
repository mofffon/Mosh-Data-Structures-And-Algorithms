import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @org.junit.jupiter.api.Test
    void whenCalled_addWith_10_20_30_itShouldReturnArrOf_10_20_30() {

        // Arrange
        Array arr = new Array(2);

        // Act
        arr.add(10);
        arr.add(20);
        arr.add(30);

        // Assert
        assertEquals("[10, 20, 30]", arr.toString());
    }

    @org.junit.jupiter.api.Test
    void whenCalled_addWith_10_20_30_itShouldReturnArrOf_10_20() {

        // Arrange
        Array arr = new Array(2);

        // Act
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);

        arr.removeAt(arr.getCurrentSize() -1);
        arr.removeAt(arr.getCurrentSize() -1);

        // Assert
        assertEquals("[10, 20]", arr.toString());
    }

    @org.junit.jupiter.api.Test
    void whenCalled_removeAtIndex0_shouldReturn10() {

        // Arrange
        Array arr = new Array(1);

        // Act
        arr.add(10);
        arr.add(20);
        arr.add(30);

        // Assert
        assertEquals(10, arr.removeAt(0));
    }

    @org.junit.jupiter.api.Test
    void whenCalled_removeAtIndex1_shouldReturn20() {

        // Arrange
        Array arr = new Array(1);

        // Act
        arr.add(10);
        arr.add(20);
        arr.add(30);

        // Assert
        assertEquals(20, arr.removeAt(1));
    }

    @org.junit.jupiter.api.Test
    void whenCalled_removeAtIndex2_shouldReturn30() {

        // Arrange
        Array arr = new Array(1);

        // Act
        arr.add(10);
        arr.add(20);
        arr.add(30);

        // Assert
        assertEquals(30, arr.removeAt(2));
    }

    @org.junit.jupiter.api.Test
    void whenCalled_indexOf10_20_30_shouldReturn0_1_2() {

        // Arrange
        Array arr = new Array(1);

        // Act
        arr.add(10);
        arr.add(20);
        arr.add(30);

        // Assert
        assertEquals(0, arr.indexOf(10));
        assertEquals(1, arr.indexOf(20));
        assertEquals(2, arr.indexOf(30));
    }

    @org.junit.jupiter.api.Test
    void whenCalled_indexOf10_20_30_shouldReturn0_1_minus1() {

        // Arrange
        Array arr = new Array(1);

        // Act
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);

        arr.removeAt(arr.getCurrentSize() - 1);
        arr.removeAt(arr.getCurrentSize() - 1);

        // Assert
        assertEquals(0, arr.indexOf(10));
        assertEquals(1, arr.indexOf(20));
        assertEquals(-1, arr.indexOf(30));
    }

    @org.junit.jupiter.api.Test
    void whenCalled_common_shouldReturnAnIntersectionOfTwoArrays(){

        // Arrange
        Array arr1 = new Array(1);
        Array arr2 = new Array(1);

        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);

        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);
        arr1.add(6);

        // Act
        Array common = arr1.intersect(arr2);

        // Assert
        assertEquals("[2, 3, 4]", common.toString());
    }

    @org.junit.jupiter.api.Test
    public void whenCalled_reverse_shouldReverseTheArray(){

        // Arrange
        Array arr0 = new Array(1);
        Array arr1 = new Array(1);
        Array arr2 = new Array(1);
        Array arr3 = new Array(1);

        arr1.add(10);

        arr2.add(10);
        arr2.add(20);

        arr3.add(10);
        arr3.add(20);
        arr3.add(30);

        // Act
        arr0.reverse();
        arr1.reverse();
        arr2.reverse();
        arr3.reverse();

        // Assert
        assertEquals("[]", arr0.toString());
        assertEquals("[10]", arr1.toString());
        assertEquals("[20, 10]", arr2.toString());
        assertEquals("[30, 20, 10]", arr3.toString());
    }

    @org.junit.jupiter.api.Test
    public void whenCalled_insertAt_shouldInsertItemAtIndex0(){

        // Arrange
        Array arr0 = new Array(1);
        Array arr1 = new Array(1);
        Array arr2 = new Array(1);
        Array arr3 = new Array(1);

        arr1.add(10);

        arr2.add(10);
        arr2.add(20);

        arr3.add(10);
        arr3.add(20);
        arr3.add(30);

        // Act
        arr0.insertAt(40,0);
        arr1.insertAt(40,0);
        arr2.insertAt(40,0);
        arr3.insertAt(40,0);

        // Assert
        assertEquals("[40]", arr0.toString());
        assertEquals("[40, 10]", arr1.toString());
        assertEquals("[40, 10, 20]", arr2.toString());
        assertEquals("[40, 10, 20, 30]", arr3.toString());
    }

    @org.junit.jupiter.api.Test
    public void whenCalled_insertAt_shouldInsertItemAtIndex1(){

        // Arrange
        Array arr1 = new Array(1);
        Array arr2 = new Array(1);
        Array arr3 = new Array(1);

        arr1.add(10);

        arr2.add(10);
        arr2.add(20);

        arr3.add(10);
        arr3.add(20);
        arr3.add(30);

        // Act
        arr1.insertAt(40,1);
        arr2.insertAt(40,1);
        arr3.insertAt(40,1);

        // Assert
        assertEquals("[10, 40]", arr1.toString());
        assertEquals("[10, 40, 20]", arr2.toString());
        assertEquals("[10, 40, 20, 30]", arr3.toString());
    }

    @org.junit.jupiter.api.Test
    public void whenCalled_insertAt_shouldInsertItemAtIndex2(){
        // Arrange
        Array arr2 = new Array(1);
        Array arr3 = new Array(1);

        arr2.add(10);
        arr2.add(20);

        arr3.add(10);
        arr3.add(20);
        arr3.add(30);

        // Act
        arr2.insertAt(40,2);
        arr3.insertAt(40,2);

        // Assert
        assertEquals("[10, 20, 40]", arr2.toString());
        assertEquals("[10, 20, 40, 30]", arr3.toString());
    }

    @org.junit.jupiter.api.Test
    public void whenCalled_insertAt_shouldInsertItemAtIndex3(){
        // Arrange
        Array arr3 = new Array(1);


        arr3.add(10);
        arr3.add(20);
        arr3.add(30);

        // Act
        arr3.insertAt(40,3);

        // Assert
        assertEquals("[10, 20, 30, 40]", arr3.toString());
    }

    @org.junit.jupiter.api.Test
    public void whenCalled_insertAt_shouldThrowIllegalArgumentException(){

        // Arrange
        Array arr0 = new Array(1);
        Array arr1 = new Array(1);
        Array arr2 = new Array(1);
        Array arr3 = new Array(1);

        arr1.add(10);

        arr2.add(10);
        arr2.add(20);

        arr3.add(10);
        arr3.add(20);
        arr3.add(30);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> arr0.insertAt(40, -1));
        assertThrows(IllegalArgumentException.class, () -> arr1.insertAt(40, -1));
        assertThrows(IllegalArgumentException.class, () -> arr2.insertAt(40, -1));
        assertThrows(IllegalArgumentException.class, () -> arr3.insertAt(40, -1));

        assertThrows(IllegalArgumentException.class, () -> arr0.insertAt(40, 1));
        assertThrows(IllegalArgumentException.class, () -> arr1.insertAt(40, 2));
        assertThrows(IllegalArgumentException.class, () -> arr2.insertAt(40, 3));
        assertThrows(IllegalArgumentException.class, () -> arr3.insertAt(40, 4));


    }
}