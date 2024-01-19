package exercise.coding102.kiwee.arrays;

public class Arrays {

    public static void main(String[] args) {
        print("hello");

        print("hello", "world");

        String[] array = { "foo", "bar" };
        print(array);

    }

    static void print(int... array) {
        if (array == null || array.length == 0) {
            System.out.println("blank ");
        }

        for (var element : array) {
            System.out.println("each element: " + element);
        }
    }

    static void print(String... array) {
        if (array == null || array.length == 0) {
            System.out.println("blank ");
        }

        for (var element : array) {
            System.out.println("each element: " + element);
        }
    }

    static void bubbleSort(int[] array) {
        int n = array.length;

        // Repeat the following steps until the array is sorted
        for (int i = 0; i < n - 1; i++) {
            // Compare adjacent numbers and swap if they are in the wrong order
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    static void selectionSort(int[] array) {
        int n = array.length;

        // Repeat the following steps until the array is sorted
        for (int i = 0; i < n - 1; i++) {
            // Assume the current index is where the smallest element is
            int minIndex = i;

            // Check the rest of the array to find a smaller element
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the smallest element with the current index
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    static void insertionSort(int[] array) {
        int n = array.length;

        // Repeat the following steps until the array is sorted
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements that are greater than key to one position ahead of their
            // current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Place the key in its correct position
            array[j + 1] = key;
        }
    }

    static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return the index where the target is found
            }
        }

        // If we reach here, the element was not present
        return -1;
    }

    static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if target is present at mid
            if (array[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            else if (array[mid] < target) {
                low = mid + 1;
            }

            // If target is smaller, ignore the right half
            else {
                high = mid - 1;
            }
        }

        // If we reach here, the element was not present
        return -1;
    }
}
