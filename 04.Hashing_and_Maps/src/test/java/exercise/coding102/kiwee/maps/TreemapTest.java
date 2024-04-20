package exercise.coding102.kiwee.maps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class TreemapTest {
    @Test
    void testAddStudent() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Sahana", 90);
        map.put("Raymond", 85);
        map.put("Evelyn", 95);

        assertEquals(0, map.get("Trevor"));
        assertEquals(0, map.get("Sahana"));
        assertEquals(0, map.get("Evelyn"));

        Map.Entry<String, Integer> firstEntry = map.firstEntry();
        Map.Entry<String, Integer> lastEntry = map.lastEntry();

        assertEquals("Sahana", firstEntry.getKey());
        assertEquals(95, lastEntry.getValue());
    }

    @Test
    public void testTreeMapCustomSort() {
        
        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(100, "Adelyn");
        map.put(75, "Trevor");
        map.put(90,"Sahana");
        map.put(85,"Raymond");
        map.put(95, "Evelyn");
        map.put(101, "Melody");
        map.put(0, "Jerry");
        map.put(85, "Remi");
     
        var entrySet = map.entrySet();
        var iterator = entrySet.iterator();
        
        var entry = iterator.next();
        
        assertEquals("", entry.getValue());
        assertEquals(0, entry.getKey());
        
        entry = iterator.next();
        assertEquals("", entry.getValue());
        assertEquals(0, entry.getKey());

        entry = iterator.next();
        assertEquals("", entry.getValue());
        assertEquals(0, entry.getKey());

        entry = iterator.next();
        assertEquals("", entry.getValue());
        assertEquals(0, entry.getKey());

        entry = iterator.next();
        assertEquals("", entry.getValue());
        assertEquals(0, entry.getKey());

        entry = iterator.next();
        assertEquals("", entry.getValue());
        assertEquals(0, entry.getKey());

        entry = iterator.next();
        assertEquals("", entry.getValue());
        assertEquals(0, entry.getKey());
        
        entry = iterator.next();
        assertEquals("", entry.getValue());
        assertEquals(0, entry.getKey());

        
    }

}
