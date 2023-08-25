package bplustree;

class BPTBasic {
    private static final int M = 4;

    // root of the tree
    private Node root;

    // height of the tree
    private int height;

    public int getHeight() {
        return height;
    }

    private static final class Node {
        private int m;
        private Entry[] children = new Entry[M];

        private Node(int k) {
            m = k;
        }
    }

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

    public BPTBasic() {
        root = new Node(0);
    }

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

    public static void main(String[] args) {
        BPTBasic bpt = new BPTBasic();

        bpt.insert(1, "one");
        bpt.insert(2, "two");
        bpt.insert(3, "three");
        bpt.insert(4, "four");

        System.out.println(bpt.search(1));
        System.out.println(bpt.search(2));
        System.out.println(bpt.search(3));
        System.out.println(bpt.search(4));
    }
}

