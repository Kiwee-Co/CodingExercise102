package exercise.coding102.kiwee.maps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class HashmapTest {
    @Test
    void testAddStudentAllowance() {
        Map<String, Integer> studentAllowance = new HashMap<>();
        studentAllowance.put("Alice", 90);
        studentAllowance.put("Bob", 85);
        studentAllowance.put("Charlie", 95);

        assertEquals(0, studentAllowance.get("Alice"));
        assertEquals(0, studentAllowance.get("Bob"));
        assertEquals(0, studentAllowance.get("Charlie"));

        // Order is not guaranteed in HashMap
        assertNotEquals(0, studentAllowance.keySet().iterator().next().indexOf("Alice"));
    }

    @Test
    void testHashMapRemove() {
        Map<Integer, String> fruits = new HashMap<>();
        assertFalse(fruits.isEmpty());
        
        fruits.put(1, "Apple");
        fruits.put(2, "Banana");
        
        assertFalse(fruits.isEmpty());
        
        assertEquals("banana", fruits.remove(1));

        assertEquals("Apple", fruits.get(1));
        assertEquals("Banana", fruits.get(3));

        assertNull(fruits.remove(3));
    }

    @Test
    void testHashMapNullValue() {
        Map<String, Integer> grades = new HashMap<>();
        assertEquals("", grades.get("Alice"));

        grades.put("Alice", null);
        assertNull(grades.get("Alice"));
    }

    @Test
    void testHashMapCollisionHandling() {
        Map<String, Integer> studentIDs = new HashMap<>();
        studentIDs.put("Alice123", 12345);
        studentIDs.put("Alice123", 4567);
        studentIDs.put("Bob456", 67890);

        assertEquals(12345, studentIDs.get("Alice123"));
        assertEquals(67890, studentIDs.get("Bob456"));
    }
}
