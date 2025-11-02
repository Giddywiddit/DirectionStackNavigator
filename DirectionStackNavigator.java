/**
 * DirectionStackNavigator.java
 * ------------------------------------------------------
 * Java program that uses a custom stack to:
 *   - Store and manage movement directions
 *   - Detect if the sequence of directions forms a palindrome
 *   - Reverse the directions to return back to the starting point
 *
 * Demonstrates:
 * - Custom stack class implementation
 * - Object-oriented design
 * - Palindrome logic using indexed stack access
 * - Control flow and algorithmic thinking
 *
 * Author: Gideon Odutayo
 * License: MIT
 * Repository: https://github.com/Giddywiddit/DirectionStackNavigator
 */

import java.util.Scanner;

// Custom Stack class with basic stack operations
class MyStack {
    private String[] stack;
    private int top;

    // Constructor to initialize the stack with a given size
    public MyStack(int size) {
        stack = new String[size];
        top = -1;
    }

    // Push an element onto the stack
    public void push(String direction) {
        if (top < stack.length - 1) {
            stack[++top] = direction;
        }
    }

    // Pop an element from the stack
    public String pop() {
        if (top >= 0) {
            return stack[top--];
        }
        return null;
    }

    // Peek at the top element
    public String peek() {
        if (top >= 0) {
            return stack[top];
        }
        return null;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get stack size
    public int size() {
        return top + 1;
    }

    // Get element at specific index
    public String get(int index) {
        if (index >= 0 && index <= top) {
            return stack[index];
        }
        return null;
    }
}

// Main program
public class DirectionStackNavigator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack(100);

        System.out.println("Enter directions (type 'Arrived' to stop):");

        // Read directions
        while (true) {
            String instruction = sc.nextLine();

            if (instruction.equals("Arrived")) {
                break;
            } else if (instruction.equals("Go Back")) {
                stack.pop();
            } else {
                stack.push(instruction);
            }
        }

        // Check if directions form a palindrome
        if (isPalindrome(stack)) {
            System.out.println("✅ The instructions are a palindrome.");
        } else {
            System.out.println("❌ The instructions are not a palindrome.");
        }

        // Reverse directions
        System.out.println("\nReversed directions to go back:");
        while (!stack.isEmpty()) {
            String direction = stack.pop();
            switch (direction) {
                case "Go North":
                    System.out.println("Go South");
                    break;
                case "Go South":
                    System.out.println("Go North");
                    break;
                case "Go East":
                    System.out.println("Go West");
                    break;
                case "Go West":
                    System.out.println("Go East");
                    break;
            }
        }

        sc.close();
    }

    // Check if the directions form a palindrome
    private static boolean isPalindrome(MyStack stack) {
        int size = stack.size();
        for (int i = 0; i < size / 2; i++) {
            if (!stack.get(i).equals(stack.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
