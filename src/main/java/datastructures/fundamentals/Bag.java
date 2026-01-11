package datastructures.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Bag Data Structure.
 *
 * <p><strong>Best Use Case:</strong>
 * Collecting items where order doesn't matter and removal is not required.
 * Useful for statistical calculations or collecting a set of objects.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Add: O(1)</li>
 *   <li>Iterate: O(n)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(n)
 */
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
