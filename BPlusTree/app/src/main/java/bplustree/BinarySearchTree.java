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
 * Binary Search Tree implementation.
 */
public class BinarySearchTree {
    // Data
    private BSTNode root;

    /**
     * Constructor.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert a value into the tree.
     * 
     * @param value
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    /**
     * Recursive helper method for insert.
     * 
     * @param root
     * @param value
     * @return
     */
    private BSTNode insertRec(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    /**
     * Search for a value in the tree.
     * 
     * @param value
     * @return
     */
    public boolean search(int value) {
        return searchRec(root, value);
    }

    /**
     * Recursive helper method for search.
     * 
     * @param root
     * @param value
     * @return
     */
    private boolean searchRec(BSTNode root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.value) {
            return true;
        }

        if (value < root.value) {
            return searchRec(root.left, value);
        } else {
            return searchRec(root.right, value);
        }
    }

    /**
     * In-order traversal of the tree.
     */
    public void inorder() {
        inorderRec(root);
    }

    /**
     * Recursive helper method for inorder.
     * 
     * @param root
     */
    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    /**
     * Returns the height of the tree.
     * @return The height of the tree.
     */
    public int height() {
        return height(root);
    }

    /**
     * A recursive helper method that computes the height of the tree.
     * @param node The current node.
     * @return The height of the subtree rooted at the given node.
     */
    private int height(BSTNode node) {
        if (node == null) {
            return -1; 
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.inorder(); // Should print: 20 30 40 50 60 70 80

        System.out.println("\n\nSearch 40: " + tree.search(40)); // true
        System.out.println("Search 100: " + tree.search(100)); // false
    }
}
