package datastructures.trees;

/**
 * Binary Search Tree (BST).
 *
 * <p><strong>Best Use Case:</strong>
 * Maintaining a sorted stream of data, implementing sets and maps.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Search/Insert/Delete: O(log n) average, O(n) worst case (unbalanced)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(n)
 */
public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}
