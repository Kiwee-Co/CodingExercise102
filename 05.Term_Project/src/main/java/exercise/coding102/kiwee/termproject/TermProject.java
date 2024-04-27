package exercise.coding102.kiwee.termproject;

import java.util.Scanner;
import java.util.concurrent.Callable;

import exercise.coding102.kiwee.termproject.utils.Util;
import picocli.CommandLine;

@CommandLine.Command(name = "CRTCalculator", mixinStandardHelpOptions = true, version = "1.0", description = "Calculates CRT of provided numbers.")
public class TermProject implements Callable<Void> {

    @Override
    public Void call() {

        try (Scanner scanner = new Scanner(System.in)) {

            var pairs = Util.loadPairsMap(scanner);

            // print out current status
            pairs.print();

            if (pairs.size() < 1) {
                System.err.println("No valid data to calculate.");
                return null;
            }

            var sum = 0;

            for (var entry : pairs.entrySet()) {
                var curDivisor = entry.getKey();

                var num = Math.product(pairs.getRestDivisors(curDivisor));
                var part = Math.findProperNumber(num, entry);

                if (part == -1) {
                    System.out.println("No solution");
                    return null;
                }

                System.out.println(String.format("Divisor: %d Remainder: %d Current State: %d", entry.getKey(), entry.getValue(), part));

                sum += part;
            }

            var lcm = Math.lcm(pairs.keySet());

            System.out.println(String.format("Solution: f(x)= %d + %dx", sum, lcm));

        }

        return null;
    }

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new TermProject());

        cmd.execute(args);
    }

}
