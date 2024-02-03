package exercise.coding102.kiwee.lists;

import org.apache.commons.lang3.ArrayUtils;

public class Lists {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };

        printLinkedList(getInstanceOf(array));
    }

    public static <E> void printLinkedList(Node<E> root) {
        Node<E> node = root;
        while (node != null) {
            System.out.println(node.getItem());
            node = node.next();
        }
    }

    static Node<Integer> getInstanceOf(int... vals) {
        if (ArrayUtils.isEmpty(vals)) {
            return null;
        }

        Node<Integer> head = new Node<>(vals[0]);

        Node<Integer> cursor = head;
        for (int i = 1; i < vals.length; i++) {
            var next = new Node<>(vals[i]);
            cursor.withNext(next);
            cursor = cursor.next();
        }

        return head;
    }
}
