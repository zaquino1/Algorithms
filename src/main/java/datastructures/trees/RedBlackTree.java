package datastructures.trees;

/**
 * Red-Black Tree (Self-Balancing BST).
 *
 * <p><strong>Best Use Case:</strong>
 * General purpose self-balancing tree (used in Java's TreeMap/TreeSet, C++ STL map).
 * Guarantees O(log n) for insert, delete, and search.
 *
 * <p><strong>Properties:</strong>
 * 1. Every node is either red or black.
 * 2. The root is always black.
 * 3. No two red nodes can be adjacent.
 * 4. Every path from a node to its descendant null nodes has the same number of black nodes.
 */
public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int key;
        Node left, right;
        boolean color;

        Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }

    private Node root;

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK;
    }

    private Node insert(Node h, int key) {
        if (h == null) return new Node(key, RED);

        if (key < h.key) h.left = insert(h.left, key);
        else if (key > h.key) h.right = insert(h.right, key);

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }
    
    public void inorder() {
        inorder(root);
    }
    
    private void inorder(Node h) {
        if (h == null) return;
        inorder(h.left);
        System.out.print(h.key + " ");
        inorder(h.right);
    }
}
