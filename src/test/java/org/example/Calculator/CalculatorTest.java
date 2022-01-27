
package org.example.Calculator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void addtwovaluesshouldreturnsum() {
        Calculator calculator = new Calculator();

        int result = calculator.add("1,2");

        assertEquals(3, result);
    }

    @Test
    void emptyStringShouldBeValid() {
        Calculator calculator = new Calculator();

        var result = calculator.add("");

        assertTrue(result == 0);
    }

    @Test
    void addManyNumbers() {
        Calculator calculator = new Calculator();

        var result = calculator.add("1,2,3,4");

        assertTrue(result == 10);
    }

    @Test
    void allowLinesBetweenNumbers() {
        Calculator calculator = new Calculator();

        var result = calculator.add("1\n2,3,");

        assertTrue(result == 6);
    }

    @Test
    void addDifferentDelimiters() {
        Calculator calculator = new Calculator();

        var result = calculator.add("//;n1;2");

        assertTrue(result == 3);

    }

    @Test
    void exceptionTesting() {
        Calculator calculator = new Calculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("-1"));

        assertEquals("negatives not allowed\n -1", exception.getMessage());
    }

    @Test
    void ignoreNumbersOverThousand() {
        Calculator calculator = new Calculator();

        var result = calculator.add("2,1001");

        assertEquals(2, result);
    }

    @Test
    void delimiterCanBeOfAnyLength() {
        Calculator calculator = new Calculator();

        var result = calculator.add("//[***]\n1***2***3");

        assertEquals(6, result);
    }

    @Test
    void allowMultipleDelimiters() {
        Calculator calculator = new Calculator();

        var result = calculator.add("//[*][%]\n1*2%3");

        assertEquals(6, result);
    }

    @Test
    void multipleDelimitersOfAnyLength() {
        Calculator calculator = new Calculator();

        var result = calculator.add("//[***][%%%]\n1***2%%%3");

        assertEquals(6, result);
    }
}

