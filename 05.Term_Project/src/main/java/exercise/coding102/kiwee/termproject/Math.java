package exercise.coding102.kiwee.termproject;

import java.util.Map.Entry;
import java.util.Set;

public final class Math {
    private Math() {
    }

    public static int findProperNumber(int current, Entry<Integer, Integer> entry) {
        return findProperNumber(current, entry.getKey(), entry.getValue());
    }

    public static int findProperNumber(int current, int divisor, int remainder) {
        int v = current;
        int count = 1;

        while (v % divisor != remainder && count < divisor) {
            v = current * (++count);
        }

        if (count == divisor) {
            return -1;
        }

        return v;
    }

    public static int product(Set<Integer> set) {
        return product(set.parallelStream().mapToInt(Integer::intValue).toArray());
    }

    public static int product(int... arr) {
        int i = 1;

        for (int n : arr) {
            i = i * n;
        }

        return i;
    }

    public static int gcd(Set<Integer> set) {
        return gcd(set.parallelStream().mapToInt(Integer::intValue).toArray());
    }

    public static int gcd(int... arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("At least one int must be provided.");
        }

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }

        return result;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static int lcm(Set<Integer> set) {
        return lcm(set.parallelStream().mapToInt(Integer::intValue).toArray());
    }

    public static int lcm(int... arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("At least one int must be provided.");
        }

        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }

        return result;
    }

    public static int lcm(int a, int b) {
        int product = a * b;
        int gcd = gcd(a, b);

        return product / gcd;
    }

}
