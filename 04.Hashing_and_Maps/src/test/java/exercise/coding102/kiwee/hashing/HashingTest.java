package exercise.coding102.kiwee.hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercise.coding102.kiwee.shared.item.Book;

class HashingTest {

    private HashingFunction hashingFunc;

    @BeforeEach
    public void setUp() {
        hashingFunc = new HashingFunction(10);
    }

    @Test
    void testEmptyString() {
        assertEquals(1, hashingFunc.hash(""));
    }

    @Test
    void testBooks() {
        var catIntheHat = new Book("Dr. Seuss", "The Cat in the Hat");
        var lorax = new Book("Dr. Seuss", "The Lorax");

        assertNotEquals(hashingFunc.hash(catIntheHat.getAuthor()), hashingFunc.hash(lorax.getAuthor()));
        assertEquals(hashingFunc.hash(catIntheHat.getBookName()), hashingFunc.hash(lorax.getBookName()));

        assertEquals(hashingFunc.bookhash(catIntheHat), hashingFunc.bookhash(lorax));
    }

    @Test
    void testGruffalo() {
        var gruffalo = new Book("Julia Donaldson", "The Gruffalo");
        var kid = new Book("Julia Donaldson", "The Gruffalo's Child");
        
        hashingFunc = new HashingFunction(1);

        assertEquals(hashingFunc.hash(gruffalo.getAuthor()), hashingFunc.hash(kid.getAuthor()));
        assertNotEquals(hashingFunc.hash(gruffalo.getBookName()), hashingFunc.hash(kid.getBookName()));
        
        assertNotEquals(hashingFunc.bookhash(gruffalo), hashingFunc.bookhash(kid));
    }
    
    @Test
    public void testStringWithSpecialCharacters() {
        assertEquals(hashingFunc.hash("apple!"), hashingFunc.hash("apple"));
    }

    @Test
    public void testUpperCaseLowerCase() {
        assertEquals(hashingFunc.hash("apple"), hashingFunc.hash("Apple"));
    }
}
