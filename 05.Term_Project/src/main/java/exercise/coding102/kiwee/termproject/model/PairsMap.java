package exercise.coding102.kiwee.termproject.model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.tuple.Pair;

public class PairsMap extends TreeMap<Integer, Integer> {
    private static final long serialVersionUID = 7661336691858893078L;

    public void print() {
        if (MapUtils.isEmpty(this)) {
            System.out.println("No input.");
        }

        System.out.printf("Overall there are %d conditions: \n", this.size());

        for (var p : this.entrySet()) {
            System.out.printf("\tdivided by %d, remainder is %d \n", p.getKey(), p.getValue());
        }
    }

    public Integer put(Pair<Integer, Integer> pair) throws NumberFormatException, IllegalArgumentException {
        var divisor = pair.getLeft();
        var remainder = pair.getRight();

        if (divisor < 2) {
            throw new NumberFormatException("Divisor cannot be less than 2");
        }

        if (this.containsKey(divisor)) {
            throw new IllegalArgumentException(String.format("Already consider %d as one of the divisors.", divisor));
        }

        if (remainder < 1) {
            throw new IllegalArgumentException(String.format("Remainder has to be greater than 0", remainder));
        }

        if (divisor <= remainder) {
            throw new NumberFormatException(String.format("Divisor %d cannot be less than or equal to %d", divisor, remainder));
        }

        return super.put(divisor, remainder);
    }

    public Set<Integer> getRestDivisors(int num) {
        var keySet = new HashSet<>(this.keySet());
        if (keySet.remove(num)) {
            return keySet;
        }
        
        return null;
    }
}
