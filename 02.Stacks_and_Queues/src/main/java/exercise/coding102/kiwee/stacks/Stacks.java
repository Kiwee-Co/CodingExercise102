package exercise.coding102.kiwee.stacks;

import java.util.Stack;

public class Stacks {

    public static void main(String[] args) {
        // Create a new stack
        Stack<String> colors = new Stack<>();

        // Push some colors onto the stack
        colors.push("Red");
        colors.push("Green");
        colors.push("Blue");

        // Print the stack
        System.out.println("Stack: " + colors);

        // Pop and print the top element
        String topColor = colors.pop();
        System.out.println("Top color: " + topColor);

        // Print the stack again
        System.out.println("Stack after pop: " + colors);
    }
}
