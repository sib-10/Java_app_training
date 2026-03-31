package com.example;

public class App {

    // --- Arithmetic ---
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    // --- String utilities ---
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, World!";
        }
        return "Hello, " + name.trim() + "!";
    }

    // --- Number classification ---
    public String classifyNumber(int n) {
        if (n > 0) {
            return "positive";
        } else if (n < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    // --- FizzBuzz (classic branch-heavy example) ---
    public String fizzBuzz(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be positive");
        }
        if (n % 15 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }

    // --- Intentionally UNTESTED method (to show coverage gaps) ---
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative input not allowed");
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Sum: " + app.add(5, 3));
        System.out.println("Palindrome: " + app.isPalindrome("racecar"));
        System.out.println("FizzBuzz(15): " + app.fizzBuzz(15));
    }
}