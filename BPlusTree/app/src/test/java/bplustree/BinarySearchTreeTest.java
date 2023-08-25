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

/**
 * Test for BSTNode and BinarySearchTree.
 */
public class BinarySearchTreeTest {

    @Test
    public void testInsertionAndSearch() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        assertTrue(tree.search(5));
        assertFalse(tree.search(10));

        tree.insert(2);
        assertTrue(tree.search(2));
        assertFalse(tree.search(10));

        tree.insert(8);
        assertTrue(tree.search(8));
        assertFalse(tree.search(10));
    }

    @Test
    public void testMultipleInsertions() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(3);
        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
        assertTrue(tree.search(5));
        assertTrue(tree.search(8));
        assertFalse(tree.search(10));
        assertFalse(tree.search(4));


        tree.insert(4);
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        assertTrue(tree.search(4));
        assertTrue(tree.search(10));
        assertTrue(tree.search(11));
        assertTrue(tree.search(12));
        assertTrue(tree.search(13));
        assertFalse(tree.search(14));
    }

    @Test
    public void testDuplicateInsertion() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(5); // should handle duplicate gracefully
        assertTrue(tree.search(5));

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.insert(9);
        tree2.insert(9); // should handle duplicate gracefully
        assertTrue(tree2.search(9));

        BinarySearchTree tree3 = new BinarySearchTree();
        tree3.insert(5);
        tree3.insert(5); // should handle duplicate gracefully
        assertTrue(tree3.search(5));
    }

    @Test
    public void testSearchEmptyTree() {
        BinarySearchTree tree = new BinarySearchTree();
        assertFalse(tree.search(5));
    }

    @Test
    public void testMinMaxIntegerValues() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(Integer.MIN_VALUE);
        tree.insert(Integer.MAX_VALUE);

        assertTrue(tree.search(Integer.MIN_VALUE));
        assertTrue(tree.search(Integer.MAX_VALUE));
    }
}
