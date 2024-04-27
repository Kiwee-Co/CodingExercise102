package exercise.coding102.kiwee.termproject.utils;

import java.util.Scanner;

import org.apache.commons.lang3.tuple.Pair;

import exercise.coding102.kiwee.termproject.model.PairsMap;

public final class Util {
    private Util() {
    }

    public static PairsMap loadPairsMap(Scanner scanner) {
        var pairs = new PairsMap();

        while (true) {
            try {
                var curr = Util.get(scanner);
                if (curr == null) {
                    break;
                }

                pairs.put(curr);

            } catch (NumberFormatException nfe) {
                System.err.println("Illegal number format, please retry: " + nfe.getMessage());
            } catch (IllegalArgumentException iae) {
                System.err.println("Invalid argument, please retry: " + iae.getMessage());
            }
        }

        return pairs;
    }

    public static Pair<Integer, Integer> get(Scanner scanner) throws NumberFormatException {
        System.out.println("Enter a divisor: ");
        var divisor = scanner.nextLine().trim();
    
        if (divisor.isEmpty()) {
            return null;
        }
    
        int divNum = Integer.parseInt(divisor);
    
        System.out.println("Enter a remainder: ");
    
        var remainder = scanner.nextLine().trim();
        if (remainder.isEmpty()) {
            return null;
        }
    
        int remainNum = Integer.parseInt(remainder);
    
        return Pair.of(divNum, remainNum);
    }

}
