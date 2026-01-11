package algorithms.searching;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sequential Search Symbol Table (Unordered Linked List).
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 3.1).
 *
 * <p><strong>Best Use Case:</strong>
 * Very small datasets.
 *
 * <p><strong>Time Complexity:</strong> O(N) for search and insert.
 */
public class SequentialSearchST<Key, Value> implements SymbolTable<Key, Value> {
    private Node first;
    private int n;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public int size() { return n; }
    public boolean isEmpty() { return size() == 0; }

    public boolean contains(Key key) { return get(key) != null; }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (Node x = first; x != null; x = x.next)
            queue.add(x.key);
        return queue;
    }
}
