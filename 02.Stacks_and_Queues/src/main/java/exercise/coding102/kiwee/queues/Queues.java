package exercise.coding102.kiwee.queues;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

public class Queues {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };

        var queue = getQueue(array);

        printQueue(queue);
    }

    private static Queue<Integer> getQueue(int... numbers) {
        if (ArrayUtils.isEmpty(numbers)) {
            return null;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            queue.add(numbers[i]);
        }

        return queue;
    }

    static <E> void printQueue(Queue<E> queue) {
        if (queue == null) {
            return;
        }
        
        System.out.println("Queue size: " + CollectionUtils.size(queue));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println("Done");
    }

}
