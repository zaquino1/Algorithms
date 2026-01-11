package datastructures.fundamentals;

import java.util.NoSuchElementException;

/**
 * Queue Data Structure (FIFO).
 *
 * <p><strong>Best Use Case:</strong>
 * Task scheduling, buffering data streams, Breadth-First Search (BFS).
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Enqueue: O(1)</li>
 *   <li>Dequeue: O(1)</li>
 *   <li>Peek: O(1)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(n)
 */
public class Queue<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<>(item);
        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
