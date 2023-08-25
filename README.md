# Research Paper
* **Name:** Yiwen Wang
* **Semester:** 2023 Summer
* **Topic:** Research on B+ Tree Data Structure
* **Link The Repository:**  https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312
* **Languages Used:** Java



## Introduction



Data structures and algorithms lie at the heart of computer science, shaping how we design, implement, and optimize software. One of the most important structures is the tree data structure. A tree data structure is a hierarchical structure used to represent and organize data in an easy way to insert, search and delete. It is a collection of nodes connected by edges and has a hierarchical relationship between them.<sup>1</sup> The development of basic trees, like Binary Trees, started in the 1950s.<sup>2</sup> Over the years, the tree data structure developed and has many different kinds of trees: B Trees, B+ Trees, AVL Trees, Red-Black Trees, Trie Tree, Heaps, etc.<sup>3</sup> This paper focuses on the [B+ Tree], a B Tree data structure variation.



The development of tree structures leading to the B+ Tree can be traced from rudimentary tree structures to more complex and specialized forms. In the 1950s and 1960s, fundamental binary trees emerged as foundational structures, with each node accommodating at most two children.<sup>4</sup> As the demand for efficiency grew, the 1960s witnessed the birth of balanced trees like the AVL Tree, which maintained optimal heights to facilitate efficient operations.<sup>5</sup> Transitioning to the late 1960s and early 1970s, the B Tree was conceptualized by Bayer and McCreight as a response to the rising need for accommodating direct-access storage mechanisms like magnetic disks.<sup>6</sup> By the mid-1970s, the B+ Tree evolved from the B Tree, centralizing values at the leaf level, enabling faster in-order traversal and becoming an asset for databases and file systems.<sup>7</sup> 



Among the vast collection of tree data structures, the B+ Tree stands out, especially in databases and file systems. B+ Trees are a type of self-balancing tree that maintain sorted data in a manner that allows for efficient insertion, deletion, and search operations.<sup>8</sup> Unlike binary trees that have a branching factor of 2, B+ Trees can have a larger number of children per node, typically determined by disk block size.<sup>9</sup> B+ Trees are optimal for storage systems with slower data access, as they reduce I/O operations and enhance disk efficiency; in addition, their balanced structure makes them preferred for database systems and applications requiring swift data retrieval, ensuring consistent performance across diverse tasks and streamlining range-based queries.<sup>10</sup>



This research paper delves deep into a comparative study of the B+ Tree by providing a comparison with B+ Tree and the Binary Search Tree (BST). The analytical framework will initially dissect the time and space complexities, offering a holistic understanding of the algorithms and their underlying mechanics. This research includes an empirical analysis: using a comparison between B+ Tree and BST, illuminating the practical performance differences between the two structures. This research then transitions to implementation, using Java to implement these two data structures and “SpeedTest” classes to collect data into a .csv file for further analysis. In conclusion, a summary will encapsulate the major findings and reflections.



## Analysis of Data Structure


The B+ Tree is a self-balancing tree data structure that optimizes sorted data for systems with block storage, such as databases and filesystems.<sup>11</sup> A B+ Tree is a multi-level data structure: with a root node at the top and one or more levels of internal nodes below it.<sup>12</sup> All values are stored at the leaf level, with internal nodes as a guide to navigating the tree quickly.<sup>13</sup> Each node contains a certain number of keys (based on its order) that segregate the tree into sub-trees, helping to minimize disk I/O operations.<sup>14</sup> All the leaf nodes are linked, enabling efficient sequential access, which is beneficial for range queries. Insertions and deletions in a B+ Tree involve redistributing keys and possibly splitting or merging nodes, but the tree always remains balanced. This ensures that operations like search, insert, and delete always have logarithmic time complexity, providing consistently fast access times even as the dataset grows.


### Time Complexity


**Search**: 
- Searching in a B+ Tree usually requires $O(log (n))$ time. Since in a B+ Tree, all values are found at leaf level, the tree's height becomes logarithmic to the number of entries. Therefore, searching involves traversing from the root down to the appropriate leaf node.

**Insertion**: 
- Insertion in a B+ Tree is also typically an $O(log (n))$ operation. While inserting, the tree might need to split if the number of keys exceeds the maximum limit. Though the process requires rebalancing the tree by splitting nodes, due to its logarithmic height, the operation remains $O(log (n))$.

**Deletion**: 
- Deletion in a B+ Tree operates at $O(log (n))$ time complexity. The node from which a value is deleted might need to be combined with a neighboring node to ensure the tree remains balanced.


The big O value is shown in the following chart:<sup>15</sup>

| Operation | Average Case | Worst Case  |
|:---------:|:------------:|:-----------:|
| Search    | $O(log (n))$  | $O(log (n))$ |
| Insertion | $O(log (n))$  | $O(log (n))$ |
| Deletion  | $O(log (n))$  | $O(log (n))$ |


### Space Complexity


The space complexity of a B+ Tree is influenced by several factors:

- **Number of Entries (`n`)**: This directly contributes to the space the tree occupies.
- **Order of the Tree (`m`)**: This signifies the maximum number of children a node can have.

Space utilization in B+ Trees is notably efficient. Given that B+ Trees were conceived primarily for systems like databases, it's vital that they use space efficiently. The specific space complexity is typically $O(n)$, since each entry in the tree accounts for some space. The tree's height is logarithmic relative to its number of keys, expressed as:$O(log_m n)$. Every node can house up to `m` children and $(m-1)$ keys.

| Property                  | Space Complexity   |
|:-------------------------:|:------------------:|
| Node (maximum)            | $(O(m))$         |
| Height of the B+ tree     | $O(log_m (n))$  |
| Total (for all nodes)     | $O(n)$       |



### Analysis



B+ Trees are an evolution of the B Tree, designed to optimize data access for systems like databases and file systems. One of the key characteristics of B+ Trees is that all values are at the leaf level, which simplifies the search process. The tree ensures balanced growth, so operations are logarithmically bound, providing predictable performance. Another notable feature of B+ Trees is the linkage of all leaf nodes, which makes range-based queries efficient. This is particularly valuable in databases where range retrievals are common. The tree's branching factor (or order) can be adjusted based on system requirements, allowing a fine balance between the depth of the tree and the number of I/O operations needed for access. In terms of real-world application, B+ Trees are particularly popular in databases and file systems due to their ability to minimize disk I/O operations. Their structure ensures that a large number of keys can be stored in a single node, which reduces the number of disk access operations, crucial for systems where disk access is a major bottleneck.



## Empirical Analysis


Empirical analysis is an evidence-based approach to the study and interpretation of information. In this section, a comparation will be provided by a comparison between B+ tree and BST. The B+ Tree and Binary Search Tree (BST) are both tree-based data structures used for storing and accessing ordered data, but they cater to different use cases. 


As mentioned above, B+ Trees are particularly designed for systems with block storage, such as databases and filesystems, where minimizing disk I/O is crucial. In B+ Trees, all values are stored at the leaf level and internal nodes guide the navigation, ensuring efficient disk access. Moreover, leaf nodes in B+ Trees are linked, enabling swift sequential reads which are beneficial for range queries. 


On the other hand, BSTs are general-purpose binary trees where each node holds a key (and often an associated value), and nodes have at most two children, based on the key's ordering. While BSTs can offer logarithmic time complexities for balanced scenarios, they can degrade to linear performance in skewed or unbalanced conditions. B+ Trees, with their self-balancing nature, consistently offer logarithmic performance, making them more predictable for large-scale storage systems.


From this Big O complexity for BST and B+ Tree, it is obvious that the most difference is at the worst case. 

| Operation     | Case          | Binary Search Tree (BST) | B+ Tree    |
|:-------------:|:-------------:|:------------------------:|:----------:|
| **Search**    | Best Case     | $O(log (n))$                 | $O(log (n))$   |
|               | Average Case  | $O(log (n))$                 | $O(log (n))$   |
|               | Worst Case    | $O(n)$                     | $O(log (n))$   |
| **Insertion** | Best Case     | $O(log (n))$                 | $O(log (n))$   |
|               | Average Case  | $O(log (n))$                 | $O(log (n))$   |
|               | Worst Case    | $O(n)$                     | $O(log (n))$   |


It is important to notice that the complexities mentioned above can vary based on the specifics of the implementation and other factors. The complexities for the B+ Tree generally hold when the tree is balanced, and the height is logarithmic to the number of entries. Similarly, the BST can degrade to O(n) in worst-case scenarios like when it becomes a skewed tree.


### Average Case Comparision


First, this research’s Java program provides random sets of numbers (from 30000 to 30000000 numbers and size added by 30000) to B+ tree and BST. This program collected and put all the data into a .csv to create charts. The chart below shows that both have the $O(log (n))$ time complexity: 


![Average Insertion Comparision](https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/IMG/Average_Insertion.png)


And for the search, it should also be $O(log (n))$, however, the time is too small here and would be easily impacted by noise so that it could not show the $O(log (n))$. 


![Average Search Comparision](https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/IMG/Average_Search.png)


And in order to see the different of height of the tree(level), the following is a chart shows the height comparision:


![Average Height Comparision](https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/IMG/Average_Height.png)


It is clear that the heights of B+ Tree is much less than BST. While when the size is 30000, the height of the BST is 31, and the height of B+ Tree is 11. And the height of B+ tree si remain at 15-16 from size 420000, and when it is size 3000000, the height of the B+ tree is 17, and BST is 52. B+ Tree is more stable of the height, however, the BST's height is not that stable. See [BPT_SPEED_TEST] &  [BST_SPEED_TEST].


Therefore, this comparison shows that they have $O(log (n))$ time complecity for insertion and search, and the BST height is larger than the B+ Tree height. However, when dealing with the average case and because it is random numbers, the insertion of B+ tree requires split, so that its insertion time is higher than BST.


### Worst Case Comparision


To further prove the efficiency of B+ Tree, it is important to compare the worst case, which is the sequantial numbers. When using a sorting list of numbers and making the BST a skewed tree (very unbalanced tree),  which is the worst case for BST (O(n) for insertion and search). The B+ tree remains balanced, so it still has O(log n) time complexity for insertion and search.   The differences are shown in bellow charts: Here I only use 100-3000 size because the BST growth too fast. And with these sample, we already could see the big differences. 


The most obvious comparison is from the insertion. It is clear that the time for the BST insertion is growth much faster than the B+ Tree insertion time. Also, the BST insertion time complexity shows as $O(n)$  and the B+ Tree insertion shows as $O(log (n))$. It is so small so that it is hard to be recognized from the chart. See [BPT_WorstCase]

![Worst Insertion Comparision](https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/IMG/WorstCase_Insertion.png)

The search time is also being impacted by the nosie and computer performance. 
![Worst Search Comparision](https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/IMG/WorstCase_Search.png)


To understand why the worst case insertion time changed, it is important to notice the height of the tree. The following chart is the height of the tree comparision(level)(See [BPT_WorstCase] & [BST_WorstCase]):
![Worst Height Comparision](https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/IMG/WorstCase_Height.png)
While the size is 100, BST has 99 height, and B+ Tree only has 5 height; and at the end of the speed test of worst case, the BST has 2999 height(for a skewed tree), and B+ Tree only has 10 height(well-blanced tree). Therefore, when inserting, the BST time is much larger than the B+ Tree time in the worst case. This shows that the BST has a huge disadvantage when dealing with an unblanced tree. 


The above comparison data shows that the choice between BST and B+ Tree often depends on the use case. when implementing a simple in-memory data structure, BST (or its balanced variants) might be preferable. However, for disk-based structures where large data blocks are involved, like databases and file systems, B+ Trees are usually a better choice.

BST has a simple structure to implement compared to B+ treees, and when dealing with an ieally balanced BST, the insertion, deletion and search time complexity is the same with the B+ Tree ($O(log (n))$), sometimes the actual time may be faster than the B+ Tree. However, In the worst case (e.g., inserting already sorted elements), a BST can degrade to a linked list, resulting in $O(n)$ time complexity for operations. This problem can be mitigated using self-balancing trees like AVL or Red-Black trees, but this adds complexity. Another disadvantage is that each node in a BST contains data and usually two pointers (left and right). This can be an overhead especially if the data portion is small.

On the other hand, B+ Trees are always balanced, ensuring  $O(log (n))$ time complexity for insertion, deletion, and search operations. Also, B+ Trees are designed to be efficient for systems that read and write large blocks of data, like databases and file systems. They reduce the number of disk I/O operations. B+ Tree provides a more efficient scanning, because all values are found at leaf level, making range queries more efficient. The B+ Tree also has a better space utilization especially when the tree is stored on disk, because nodes can have multiple children(more than 2). The most worst part of the B+ trees are that it is very complext to implement. Another disadvantage is that, when inserting or deleting keys, a node may become too full or too empty, necessitating a split or merge operation. However, these operations are relatively rare compared to the number of simple insertions or deletions.



## Application


### a. Usage of the Data Structure: 
B+ Trees are primarily used in systems where data is stored in blocks and where minimizing the number of disk access operations (I/O) is crucial. The structure of the B+ Tree, particularly its ability to store multiple keys in a node and its self-balancing nature, is designed to enhance data retrieval and storage efficiency in such environments.<sup>16</sup>


### b. Why use:
B+ Trees are particularly valuable in areas where data is stored in large blocks and where minimizing disk access is essential. Their structure, where all values are stored at the leaf level and leaf nodes are interconnected, allows for rapid sequential data access. This is especially beneficial for range-based queries.<sup>17</sup> Moreover, the self-balancing property of B+ Trees ensures that search, insertion, and deletion operations always take logarithmic time, making data operations predictably fast. In the context of databases and file systems, where vast amounts of data need to be accessed or modified rapidly and frequently, the benefits of B+ Trees in reducing I/O operations are substantial.<sup>18</sup>


### c. Examples:
**Databases:** B+ Trees are a common choice for indexing in relational database management systems (RDBMS). They allow databases to quickly locate rows of data without searching through every row in a dataset, making read operations more efficient. For instance, MySQL's InnoDB storage engine uses a clustered B+ Tree index to organize its data.<sup>19</sup>

**File Systems:** File systems such as the NTFS used by Windows are known to utilize B+ Trees for their metadata storage. The tree structure allows the file system to quickly locate files, making file retrieval and storage operations speedy.<sup>20</sup>

**Geographic Information Systems (GIS):** B+ Trees can be used in GIS to quickly retrieve spatial data, aiding in efficient spatial queries, especially in range-based searches.<sup>21</sup>



## Implementation


I used **Java** to implements the B+ tree and BST. I used standard java libraries for the code. The code writing can be found in the following files:


* [Constants]: Store all the constants
* [NumberGenerator]: generate random numbers or sorted numbers for speed test

* [BinarySearchTree]: A java class for Binary Search Tree 
* [BSTNode]: A java class for BST's node
* [B+Tree]: A java class for implementing basic B+ tree with insertion and search 

* [BSTSpeedTest]: BST data collector for average case
* [BPTSpeedTest]: BPT data collector for average case 

* [BSTWorstTest]: BST data collector for worst case
* [BPTWorstTest]: BPT data collector for worst case


The biggest challenge I faced is that the B+ tree structure is complex: ensuring that both directory and leaf nodes use a unified Node structure while maintaining different behaviors; maintaining the linked list pointers among leaf nodes during insertion and splitting. So for this basic version of B+ tree, only insertion and search are provided for comparison in this research. This is the limitation of this paper and would be the next research process in the future. 


**While implementing B+ Tree, I have the following key points:**


**First,** I unified the Node Structure by:


```java
private static final class Node {
        private int m;
        private Entry[] children = new Entry[M];

        private Node(int k) {
            m = k;
        }
    }
```

Here, a single Node class is used to represent both directory and leaf nodes. The distinction is made by how the entries inside them are used. Directory nodes use the next reference of their entries to point to child nodes, while leaf nodes use the nextEntry reference to form a linked list of entries.


**Second,** I have this entry Structure: 


```java
private static class Entry {
        private int key;
        private Object val;
        private Node next;       // Used when this entry is a directory node entry
        private Entry nextEntry; // Used when this entry is a leaf node entry

        public Entry(int key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.nextEntry = null;
        }
    }
```
The Entry class represents a key-value pair. For directory nodes, the next reference points to a child node. For leaf nodes, the nextEntry reference points to the next entry, forming a linked list.


**Third,** I have a search operation: 

```java
    public Object search(int key) {
            return search(root, key, height);
        }

    private Object search(Node node, int key, int height) {
        Entry[] children = node.children;

        // when we reach the leaf node, serach the list
        if (height == 0) {
            for (int j = 0; j < node.m; j++) {
                if (key == children[j].key) {
                    return children[j].val;
                }
            }
        } else {
        // when it's not the leaf node, search the directory node
            for (int j = 0; j < node.m; j++) {
                if (j + 1 == node.m || key < children[j + 1].key) {
                    // recursively search the next node when the key is smaller than the next key
                    return search(children[j].next, key, height - 1);
                }
            }
        }
        // return null when the key is not found in the whole tree
        return null;
    }
```
The search operation starts at the root and traverses the tree. At each node, if it's a leaf node (height == 0), the method searches linearly for the key. If it's a directory node, it determines which child node to move to next based on the key comparisons.


**Forth,** I got the operation with split: 

```java
     public void insert(int key, Object val) {
        Node node = insert(root, key, val, height);

        // if null that means no need to split the node.
        if (node == null) {
            return;
        }
        
        // if not null, split the node and create a new root.

        Node newRoot = new Node(2);
        newRoot.children[0] = new Entry(root.children[0].key, null, root);
        newRoot.children[1] = new Entry(node.children[0].key, null, node);
        root = newRoot;
        height++;
    }

    private Node insert(Node node, int key, Object val, int height) {
        int j;
        Entry t = new Entry(key, val, null);

        // when reach the leaf node, insert the entry into the list
        if (height == 0) {
            for (j = 0; j < node.m; j++) {
                if (key < node.children[j].key) {
                    break;
                }
            }
            // Adjust linked list pointers when adding to a leaf node
            if (j < node.m - 1) {
                t.nextEntry = node.children[j].nextEntry;
            }
            if (j > 0) {
                node.children[j - 1].nextEntry = t;
            }
        } else {
            for (j = 0; j < node.m; j++) {
                if ((j + 1 == node.m) || key < node.children[j + 1].key) {
                    Node u = insert(node.children[j++].next, key, val, height - 1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        // find the correct position to insert the entry
        for (int i = node.m; i > j; i--) {
            node.children[i] = node.children[i - 1];
        }
        node.children[j] = t;
        node.m++;

        // if enough space in the current node, return null, so that we don't need to split the node. 
        if (node.m < M) {
            return null;
        }
        // otherwise split the node. 
        return split(node);
    }
```


When inserting, the code first traverses down to the appropriate leaf node. If a node becomes full after insertion (node.m >= M), it's split into two nodes using the split method.

```java
    // split the node into two nodes, return the new node
    private Node split(Node node) {
        Node next = new Node(M / 2);
        node.m = M / 2;

        for (int j = 0; j < M / 2; j++) {
            next.children[j] = node.children[M / 2 + j];
        }

        if (next.children[0].val != null) {
            node.children[node.m - 1].nextEntry = next.children[0];
        }

        return next;
    }
```


Splitting a node involves creating a new node and moving half of the entries to this new node. If the node being split is a leaf node, the linked list pointers are adjusted to ensure continuity among the leaf nodes.


After implementing the B+ Tree, I created the BST class. For the empirical analysis, I added height method:
```java
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
```

To get the data, I added [BSTSpeedTest], [BPTSpeedTest], [BSTWorstTest], and [BPTWorstTest], which could auto-save to the .csv, and I used excel to create the above charts. I used a constants class to manage all constants:

```java
public class Constants {

    
    public static final int START_NUM_ENTRIES = 30000;
    public static final int END_NUM_ENTRIES = 3000000;
    public static final int INCREMENT_NUM_ENTRIES = 30000;

    public static final String BPT_CSV_PATH = "BPT_SPEED_TEST.csv";
    public static final String BST_CSV_PATH = "BST_SPEED_TEST.csv";

    public static final int START_NUM_ENTRIES_WORST = 100;
    public static final int END_NUM_ENTRIES_WORST = 3000;
    public static final int INCREMENT_NUM_ENTRIES_WORST = 100;

    public static final String BPT_CSV_PATH_WORST = "BPT_WORST_SPEED_TEST.csv";
    public static final String BST_CSV_PATH_WORST = "BST_WORST_SPEED_TEST.csv";

}
```


Also I have the number generator class to help create data to do the speed test:
```java
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
```

I also will have a system print out at the terminal for me to check the data easily without opening the .csv file. In addition, the search time is less than 1 ms so that I have to convert it. All the speed test main method looks like this: 
```java
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

```

The B+ Tree is a balanced tree structure that ensures efficient search, insert, and delete operations. This implementation showcases the search and insert operations. This code provides a unified way of handling both directory and leaf nodes, which simplifies the tree structure while still ensuring the B+ Tree properties. The linked list among the leaf nodes is crucial. It provides the ability to do efficient range searches, although this feature isn't shown in the provided operations. This implementation doesn't account for node merging or redistribution during deletion. This means In order to implement deletion, it is necessary to handle cases where a node becomes underfull. This is the limitation of this research paper and future development for this topic. 



## Summary

This research undertook an empirical analysis, rooted in evidence-based methodology, comparing B+ Trees and Binary Search Trees (BSTs). Both are tree-based data structures designed for ordered data storage and retrieval, but their applications differ significantly.

B+ Trees, tailored for block storage systems like databases and filesystems, prioritize minimizing disk I/O. Key distinctions include storing values at the leaf level and maintaining linked leaf nodes, which promote efficient disk access and expedited sequential reads, particularly beneficial for range queries. In contrast, BSTs are versatile binary trees with nodes that maintain a key and up to two child nodes based on key ordering. Although BSTs can offer logarithmic performances in balanced states, they can degrade to linear performance when unbalanced. B+ Trees, inherently self-balancing, maintain a more consistent logarithmic performance, making them a preferred choice for large storage systems.

The Big O complexity comparison indicates substantial disparities during worst-case scenarios. Empirical data gathered from a Java program, which processed random number sets ranging from 30,000 to 30,000,000, demonstrated that both B+ Trees and BSTs generally adhere to $O(log(n))$ time complexity. However, average case comparisons showed that the B+ Tree insertion time, potentially owing to required splits, was marginally higher than that of BSTs.

More pronounced differences emerged during worst-case evaluations, which processed sequential numbers rendering BSTs skewed (very unbalanced). While B+ Trees retained their balanced state and $O(log(n))$ complexity for both insertion and search, BSTs illustrated linear $O(n)$ complexities. Visual representations of insertion, search, and tree height comparisons for both average and worst-case scenarios further accentuated these observations. The height comparison, in particular, underscored the stability of B+ Tree heights in contrast to the more volatile BST heights.

In summary, the choice between BSTs and B+ Trees hinges largely on the application context. While BSTs may be suitable for simpler in-memory structures, B+ Trees stand out for disk-based systems dealing with extensive data blocks, like databases and file systems, due to their consistent performance and efficient disk I/O operations. BSTs, although simpler to implement, may present performance challenges, especially in worst-case scenarios. On the contrary, B+ Trees, though complex to implement, guarantee consistent $O(log(n))$ time complexity across operations and efficient range queries, making them indispensable for specific use cases.


From this research paper, I learnt that it is important to notice the different way of treating data, every data structure has its advantages and disadvantages. It is imporant to use correct data structure to get more efficient way as needed. 




## Reference
1. GeeksforGeeks, Introduction to Tree – Data Structure and Algorithm Tutorials, https://www.geeksforgeeks.org/introduction-to-tree-data-structure-and-algorithm-tutorials/
2. Adelson-Velskii, G., & Landis, E. M. (1962). An algorithm for the organization of information. Soviet Mathematics Doklady, 3, 1259-1263.
3. Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). Introduction to algorithms. MIT press.
4. Knuth, D. E. (1968). The art of computer programming, volume 1: fundamental algorithms. Addison-Wesley.
5. _See 2_
6. Bayer, R., & McCreight, E. M. (1972). Organization and Maintenance of Large Ordered Indices. Acta Informatica, 1(3), 173-189.
7. Comer, D. (1979). Ubiquitous B-tree. ACM Computing Surveys (CSUR), 11(2), 121-137.
8. GeeksforGeeks, SaagnikAdhikary, Introduction of B+ Tree, https://www.geeksforgeeks.org/introduction-of-b-tree/
9. _See 5_
10. _See 8_
11. _See 8_
12. _See 8_
13. _See 7_
14. _See 8_
15. _See 3 & See 7_
16. _See 3 & See 7_
17. _See 7_
18. _See 7_
19. _See 8_
20. Silberschatz, A., Korth, H. F., & Sudarshan, S. (2010). Database system concepts. McGraw-Hill.
21. Carrier, B. (2005). File System Forensic Analysis. Addison-Wesley Professional.
22. _See 7_


<!-- auto references -->
[B+ Tree]: https://www.geeksforgeeks.org/introduction-of-b-tree/
[BPT_WorstCase]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPT_WORST_SPEED_TEST.csv
[BST_WorstCase]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BST_WORST_SPEED_TEST.csv
[BPT_SPEED_TEST]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPT_SPEED_TEST.csv
[BST_SPEED_TEST]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BST_SPEED_TEST.csv
[Constants]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/Constants.java
[NumberGenerator]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/NumberGenerator.java
[BinarySearchTree]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/BinarySearchTree.java
[BSTNode]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/BSTNode.java
[B+Tree]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/BPTBasic.java
[BSTSpeedTest]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/BSTSpeedTest.java
[BPTSpeedTest]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/BPTSpeedTest.java
[BSTWorstTest]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/BSTWorstCase.java
[BPTWorstTest]: https://github.com/Su23-CS5008-Online-Lionelle/finalresearchpaper-YiwenW312/blob/main/BPlusTree/app/src/main/java/bplustree/BPTWorstCase.java