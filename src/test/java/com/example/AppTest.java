package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    // --- Arithmetic tests ---
    @Test
    void testAdd() {
        assertEquals(8, app.add(5, 3));
        assertEquals(0, app.add(-1, 1));
    }

    @Test
    void testSubtract() {
        assertEquals(2, app.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, app.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, app.divide(5, 2), 0.001);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> app.divide(5, 0));
    }

    // --- String utility tests ---
    @Test
    void testIsPalindromeTrue() {
        assertTrue(app.isPalindrome("racecar"));
        assertTrue(app.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(app.isPalindrome("hello"));
    }

    @Test
    void testIsPalindromeNull() {
        assertFalse(app.isPalindrome(null));
    }

    @Test
    void testGreetWithName() {
        assertEquals("Hello, Alice!", app.greet("Alice"));
    }

    @Test
    void testGreetWithNull() {
        assertEquals("Hello, World!", app.greet(null));
    }

    @Test
    void testGreetWithBlank() {
        assertEquals("Hello, World!", app.greet("   "));
    }

    // --- Number classification tests ---
    @Test
    void testClassifyPositive() {
        assertEquals("positive", app.classifyNumber(42));
    }

    @Test
    void testClassifyNegative() {
        assertEquals("negative", app.classifyNumber(-7));
    }

    @Test
    void testClassifyZero() {
        assertEquals("zero", app.classifyNumber(0));
    }

    @Test
    void testIsEven() {
        assertTrue(app.isEven(4));
        assertFalse(app.isEven(3));
    }

    // --- FizzBuzz tests ---
    @Test
    void testFizzBuzzFizz() {
        assertEquals("Fizz", app.fizzBuzz(9));
    }

    @Test
    void testFizzBuzzBuzz() {
        assertEquals("Buzz", app.fizzBuzz(10));
    }

    @Test
    void testFizzBuzzFizzBuzz() {
        assertEquals("FizzBuzz", app.fizzBuzz(15));
    }

    @Test
    void testFizzBuzzNumber() {
        assertEquals("7", app.fizzBuzz(7));
    }

    @Test
    void testFizzBuzzInvalid() {
        assertThrows(IllegalArgumentException.class, () -> app.fizzBuzz(0));
    }

    // NOTE: factorial() is intentionally NOT tested here
    //       to demonstrate a coverage gap in the JaCoCo report.
}