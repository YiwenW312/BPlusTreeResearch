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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BPTBasicTest {

    private BPTBasic bpt;

    @BeforeEach
    void setUp() {
        bpt = new BPTBasic();
    }

    @Test
    void testInsertAndSearch() {
        bpt.insert(1, "one");
        bpt.insert(2, "two");
        bpt.insert(3, "three");
        bpt.insert(4, "four");

        assertEquals("one", bpt.search(1));
        assertEquals("two", bpt.search(2));
        assertEquals("three", bpt.search(3));
        assertEquals("four", bpt.search(4));
    }

    @Test
    void testSearchForNonExistentKey() {
        assertNull(bpt.search(5));
    }

    @Test
    void testTreeHeightAfterInsertions() {
        bpt.insert(1, "one");
        bpt.insert(2, "two");
        bpt.insert(3, "three");
        bpt.insert(4, "four");
        
        // Note: This assertion will change based on the tree height after the insertions. 
        // It assumes that the provided insertions cause the tree height to increase by 1.
        assertEquals(1, bpt.getHeight());
    }

    // Further tests can be added as necessary, for example to test boundary conditions, 
    // insertion and searching of more complex data, or other properties of the B+ Tree.
}