package bplustree;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BPTWorstCase {
    public static void main(String[] args) {
        // Print header for console table
        System.out.println("-------------------------------------------------------------");
        System.out.println("                    BPT Speed Worst Test                     ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|  Size   | Insertion Time (ms) | Search Time (ms) | Height |");
        System.out.println("-------------------------------------------------------------");



        // Initialize the CSV file with headers
        try (PrintWriter writer = new PrintWriter(Constants.BPT_CSV_PATH_WORST)) {
            // Write the header row to CSV
            writer.println("Size,Insertion Time (ms),Search Time (ms),Height");

            for (int size = Constants.START_NUM_ENTRIES_WORST; size <= Constants.END_NUM_ENTRIES_WORST; size += Constants.INCREMENT_NUM_ENTRIES_WORST) {
                // Reset the tree for each iteration
                BPTBasic bPlusTree = new BPTBasic();
                // Auto-generate numbers
                List<Integer> randomNumbers = NumberGenerator.generateSequentialNumbers(size);

                // Insert numbers and time it
                long startTime = System.nanoTime();
                for (Integer num : randomNumbers) {
                    bPlusTree.insert(num, num);
                }
                long endTime = System.nanoTime();
                double insertionDuration = (endTime - startTime) / 1_000_000.0;  // convert to milliseconds

                // Speed test for searching a value
                startTime = System.nanoTime();
                bPlusTree.search(randomNumbers.get(size/2)); // Picking the middle number for testing purposes
                endTime = System.nanoTime();
                double searchDuration = (endTime - startTime) / 1_000_000.0;  // convert to milliseconds

                //get the height of the tree
                int height = bPlusTree.getHeight();

                // Print results to console in tabulated format
                System.out.printf("| %8d  | %19.5f | %16.5f | %6d|\n", size, insertionDuration, searchDuration, height);

                //Write results to the CSV file
                writer.printf("%d,%.5f,%.5f,%d\n", size, insertionDuration, searchDuration, height);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to CSV: " + e.getMessage());
        }
    }
}
