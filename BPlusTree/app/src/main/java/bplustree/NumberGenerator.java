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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates random numbers for testing purposes.
 */
public class NumberGenerator {
    /**
     * Generates a list of random numbers.
     * 
     * @return
     */
    public static List<Integer> generateRandomNumbers() {
        return generateRandomNumbers(Constants.END_NUM_ENTRIES);
    }

    public static List<Integer> generateRandomNumbers(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }

        List<Integer> numbers = new ArrayList<>(size);
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            numbers.add(rand.nextInt(Integer.MAX_VALUE));
        }

        return numbers;
    }

    public static List<Integer> generateSequentialNumbers(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }

        List<Integer> numbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
