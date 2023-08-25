/**
 * This is the code part of the B+ tree research project. This Java project contains the Binary
 * Search Tree and B+ Tree implementations, their speed test, a number genertor.
 *
 * @YiwenW312 Yiwen Wang
 *
 *
 * @since 2023-08-07
 */
package bplustree;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class NumberGeneratorTest {

    @Test
    public void testDefaultSize() {
        List<Integer> numbers = NumberGenerator.generateRandomNumbers();
        assertEquals(Constants.END_NUM_ENTRIES, numbers.size());

        numbers = NumberGenerator.generateRandomNumbers();
        assertEquals(Constants.END_NUM_ENTRIES, numbers.size());

        numbers = NumberGenerator.generateRandomNumbers();
        assertEquals(Constants.END_NUM_ENTRIES, numbers.size());
    }

    @Test
    public void testSpecificSize() {
        List<Integer> numbers = NumberGenerator.generateRandomNumbers(1000);
        assertEquals(1000, numbers.size());

        numbers = NumberGenerator.generateRandomNumbers(10000);
        assertEquals(10000, numbers.size());

        numbers = NumberGenerator.generateRandomNumbers(100000);
        assertEquals(100000, numbers.size());
    }

    @Test
    public void testNegativeSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberGenerator.generateRandomNumbers(-1000);
        });
        String expectedMessage = "Size must be non-negative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            NumberGenerator.generateRandomNumbers(-25);
        });
        String expectedMessage2 = "Size must be non-negative";
        String actualMessage2 = exception2.getMessage();
        assertTrue(actualMessage2.contains(expectedMessage2));

        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
            NumberGenerator.generateRandomNumbers(-25);
        });
        String expectedMessage3 = "Size must be non-negative";
        String actualMessage3 = exception3.getMessage();
        assertTrue(actualMessage3.contains(expectedMessage3));
    }

    @Test
    public void testSquentialNumbers() {
        List<Integer> numbers = NumberGenerator.generateSequentialNumbers(1000);
        assertEquals(1000, numbers.size());

        numbers = NumberGenerator.generateSequentialNumbers(10000);
        assertEquals(10000, numbers.size());

        numbers = NumberGenerator.generateSequentialNumbers(100000);
        assertEquals(100000, numbers.size());
    }

    @Test
    public void testNegativeSequentialNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberGenerator.generateSequentialNumbers(-1000);
        });
        String expectedMessage = "Size must be non-negative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            NumberGenerator.generateSequentialNumbers(-25);
        });
        String expectedMessage2 = "Size must be non-negative";
        String actualMessage2 = exception2.getMessage();
        assertTrue(actualMessage2.contains(expectedMessage2));

        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
            NumberGenerator.generateSequentialNumbers(-25);
        });
        String expectedMessage3 = "Size must be non-negative";
        String actualMessage3 = exception3.getMessage();
        assertTrue(actualMessage3.contains(expectedMessage3));
    }
}
