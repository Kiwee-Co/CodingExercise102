package exercise.coding102.kiwee.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ArraysTest {
    @Test
    void testArrayInitialization() {
        // Test array initialization
        int[] array = new int[5];
        assertNotNull(array);
        assertEquals(3, array.length);
    }

    @Test
    void testArrayAccess() {
        // Test array access
        int[] array = { 1, 2, 3, 4, 5 };
        assertEquals(1, array[0]);
        assertEquals(3, array[4]);
    }

    @Test
    void testArrayModification() {
        // Test array modification
        int[] array = { 1, 2, 3 };
        array[1] = 5;
        assertEquals(2, array[1]);
    }

    @Test
    void testArraySum() {
        // Test finding the sum of elements in an array
        int[] array = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        assertEquals(10, sum);
    }

    @Test
    void testEmptyArray() {
        // Test with an empty array
        int[] array = {};
        assertEquals(0, array.length);
    }

    @Test
    void testArrayEquality() {
        // Test array equality
        int[] array1 = { 1, 2, 3 };
        int[] array2 = { 1, 2, 3 };
        
        assertArrayEquals(array1, array2);
        
        assertEquals(0, Arrays.binarySearch(array1, 3));
        assertEquals(0, Arrays.binarySearch(array1, 5));
    }

    @Test
    void testSortingAndLookup() {
        int[] array = { 3, 2, 1, 0 };

        assertEquals(3, Arrays.linearSearch(array, 0));
        
        int[] array2 = { 2, 3, 0, 1 };

        assertNotEquals(2, Arrays.binarySearch(array2, 0));

        
        int[] array3 = { 1, 3, 2, 0 };
        
        assertNotEquals(3, Arrays.binarySearch(array3, 0));

        assertArrayEquals(array, array2);
        assertArrayEquals(array, array3);
    }
}
