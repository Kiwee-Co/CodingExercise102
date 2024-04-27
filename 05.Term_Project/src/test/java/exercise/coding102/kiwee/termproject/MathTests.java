package exercise.coding102.kiwee.termproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MathTests {

    @Test
    void testGCD() {
        assertEquals(2, Math.gcd(2, 4));
        assertEquals(10, Math.gcd(20, 30));
        assertEquals(4, Math.gcd(100, 36));
        assertEquals(2, Math.gcd(20, 36, 250, 48));
    }

    @Test
    void testLCM() {
        assertEquals(4, Math.lcm(2, 4));
        assertEquals(60, Math.lcm(20, 30));
        assertEquals(900, Math.lcm(100, 36));
        assertEquals(210, Math.lcm(2, 3, 5, 7));
        assertEquals(18000, Math.lcm(20, 36, 250, 48));
    }

    @Test
    void testProduct() {
        assertEquals(10, Math.product(2, 5));
        assertEquals(70, Math.product(2, 5, 7));
        assertEquals(210, Math.product(2, 3, 5, 7));
    }

    @Test
    void findProperNumber() {
        assertEquals(45, Math.findProperNumber(15, 7, 3));
        assertEquals(28, Math.findProperNumber(14, 5, 3));

        assertEquals(-1, Math.findProperNumber(30, 4, 3));
    }
}
