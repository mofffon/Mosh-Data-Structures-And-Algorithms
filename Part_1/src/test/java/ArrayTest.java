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
}