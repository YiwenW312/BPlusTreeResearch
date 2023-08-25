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

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Speed test for Binary Search Tree.
 */
public class BSTSpeedTest {

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Print header for console table
        System.out.println("-------------------------------------------------------------");
        System.out.println("                     BST Speed Test                   ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|  Size   | Insertion Time (ms) | Search Time (ms) | Height |");
        System.out.println("-------------------------------------------------------------");

        try (PrintWriter writer = new PrintWriter(new File(Constants.BST_CSV_PATH))) {
            // Write the header row to CSV
            writer.println("Size,Insertion Time (ms),Search Time (ms),Height");

            for (int numEntries = Constants.START_NUM_ENTRIES; numEntries <= Constants.END_NUM_ENTRIES; numEntries += Constants.INCREMENT_NUM_ENTRIES) {
                BinarySearchTree tree = new BinarySearchTree();
                List<Integer> numbers = NumberGenerator.generateRandomNumbers(numEntries);

                // Measure time taken for insertion
                long startInsertTime = System.nanoTime();
                for (Integer num : numbers) {
                    tree.insert(num);
                }
                long endInsertTime = System.nanoTime();
                double insertionTime = (endInsertTime - startInsertTime) / 1_000_000.0;

                // Measure time taken for searching
                long startSearchTime = System.nanoTime();
                tree.search(numbers.get(new Random().nextInt(numEntries))); // Search for a random number from the list
                long endSearchTime = System.nanoTime();
                double searchTime = (endSearchTime - startSearchTime) / 1_000_000.0;

                // Get the height of the tree
                int height = tree.height();

                // Print results to console in tabulated format
                System.out.printf("| %8d  | %19.5f | %16.5f | %6d|\n", numEntries, insertionTime, searchTime, height);

                // Write results to the CSV file
                writer.printf("%d,%.5f,%.5f, %d\n", numEntries, insertionTime, searchTime, height);
            }

            System.out.println("-----------------------------------------------------");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}