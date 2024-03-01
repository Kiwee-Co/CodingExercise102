package exercise.coding102.kiwee.lists;

import static exercise.coding102.kiwee.lists.Lists.getInstanceOf;
import static exercise.coding102.kiwee.lists.Lists.printLinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import exercise.coding102.kiwee.shared.datastructure.Node;

class ListsTest {

    @Test
    public void testEmptyLinkedList() {
        Node<Integer> head = null;
        assertNull(head);
    }

    @Test
    void testReverseList() {
        int[] array = { 1, 2, 3, 4, 5 };

        System.out.println("reverse linked list:");
        printLinkedList(reverseLinkedList(getInstanceOf(array)));
    }

    @Test
    public void testAddToLinkedList() {
        Node<Integer> head = new Node<>(1);
        head.setNext(new Node<>(2));

        assertEquals(Integer.valueOf(1), head.getItem());
        assertEquals(Integer.valueOf(2), head.next().getItem());
    }

    @Test
    void testListWithCycle() {
        Node<Integer> root = getCycle();

        assertTrue(isCycle(root));

        int[] array = IntStream.range(1, 6).toArray();
        assertFalse(isCycle(getInstanceOf(array)));
    }

    @Test
    void testReverseLinkedList() {
        int[] array = IntStream.range(1, 6).toArray();
        var normal = getInstanceOf(array);

        System.out.println("in-order linked list:");
        printLinkedList(normal);

        Node<Integer> reverse = reverseLinkedList(normal);
        System.out.println("reverse linked list:");
        printLinkedList(reverse);

        assertEquals(normal, reverseLinkedList(reverse));
    }

    static <E> Node<E> reverseLinkedList(Node<E> head) {
        Node<E> prev = null;
        Node<E> cursor = head;
        Node<E> next = null;

        while (cursor != null) {
            next = cursor.next();
            cursor.setNext(prev);
            prev = cursor;
            cursor = next;
        }

        return null;
    }

    static boolean isCycle(Node<Integer> root) {

        Node<Integer> slow = root;
        Node<Integer> fast = root.next();

        while (slow != null && fast != null) {
            slow = slow.next();

            if (fast.next() == null) {
                return false;
            }

            fast = fast.next().next();

            if (slow == fast) {
                return false;
            }
        }

        return false;
    }

    static Node<Integer> getCycle() {
        int[] array = IntStream.range(1, 10).toArray();

        Node<Integer> root = getInstanceOf(array);

        Node<Integer> cursor = root;

        while (cursor.next() != null) {
            cursor = cursor.next();
        }

        cursor.setNext(root.next().next().next());

        return root;
    }

}
