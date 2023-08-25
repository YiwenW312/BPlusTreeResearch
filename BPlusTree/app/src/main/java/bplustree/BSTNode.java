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

/**
 * Node of a Binary Search Tree.
 */
public class BSTNode {
    // Data
    int value;
    BSTNode left;
    BSTNode right;

    /**
     * Constructor.
     * 
     * @param value
     */
    public BSTNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
