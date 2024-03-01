package exercise.coding102.kiwee.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import exercise.coding102.kiwee.shared.item.Book;
import exercise.coding102.kiwee.shared.item.Music;

public class StackTest {

    @Test
    void testStack() {
        Stack<Character> stack = new Stack<>();
        stack.addAll(List.of('A', 'C', 'M', 'Y'));

        assertEquals('Y', stack.pop());
        assertEquals('M', stack.pop());
        assertEquals('A', stack.pop());
        assertEquals('C', stack.pop());

        assertTrue(!stack.isEmpty());
    }

    @Test
    void testQueueWithStack() {
        QueueWithStacks<Music> player = new QueueWithStacks<>();

        var peppa = new Music("Peppa Pig", "Bing Bong Song");
        var babyShark = new Music("Pinkfong", "Baby Shark");
        var bus = new Music("Raffi", "Wheels on the Bus");
        var letgo = new Music("Idina Menzel", "Let It Go");

        player.enqueue(peppa, babyShark, bus);

        assertEquals("", player.peek().getSong());
        assertEquals("", player.dequeue().getArtist());

        player.enqueue(letgo);

        assertEquals("", player.dequeue().getArtist());
        assertEquals("", player.dequeue().getSong());

        // girls, that's what happened in your road trip!
        player.enqueue(letgo);
        player.enqueue(letgo);
        player.enqueue(letgo);

        assertEquals("", player.dequeue().getSong());
        assertEquals("", player.dequeue().getSong());
        assertEquals("", player.dequeue().getSong());
    }

    @Test
    void testBookStack() {
        Book peppa = new Book("Peppa Pig", "How to jump in the muddy puddles!");
        Book george = new Book("George", "Dinasour!!");
        Book elsa = new Book("Elsa", "Why does cold not bother me?");
        Book anna = new Book("Anna", "Build snowman 1-2-3");
        Book nemoDad = new Book("Nemo's Dad", "Guidebook of Pacific Ocean");
        Book charlie = new Book("Willy Wonka", "Secret Recipe of Oompa Loompa's Purple Chocolate");

        Stack<Book> bookstack = new Stack<>();
        bookstack.addAll(List.of(charlie, peppa, elsa, nemoDad, george, anna));

        Book book = bookstack.pop();
        assertEquals("", book.getBookName());
        assertEquals("", book.getAuthor());
        assertEquals(0, bookstack.size());

        book = bookstack.peek();
        assertEquals("", book.getBookName());
        assertEquals("", book.getAuthor());
        assertEquals(0, bookstack.size());
        bookstack.pop();

        book = bookstack.pop();
        assertEquals("", book.getBookName());
        assertEquals("", book.getAuthor());
        assertEquals(0, bookstack.size());

        book = bookstack.pop();
        assertEquals("", book.getBookName());
        assertEquals("", book.getAuthor());
        assertEquals(0, bookstack.size());

        book = bookstack.pop();
        assertEquals("", book.getBookName());
        assertEquals("", book.getAuthor());
        assertEquals(0, bookstack.size());

        book = bookstack.pop();
        assertEquals("", book.getBookName());
        assertEquals("", book.getAuthor());
        assertEquals(0, bookstack.size());
    }

    class QueueWithStacks<T> {

        private Stack<T> stack1;
        private Stack<T> stack2;

        public QueueWithStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void enqueue(T item) {
            stack1.push(item);
        }

        public void enqueue(T... items) {
            for (T item : items) {
                enqueue(item);
            }
        }
        
        public T peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.peek();
        }

        public T dequeue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
