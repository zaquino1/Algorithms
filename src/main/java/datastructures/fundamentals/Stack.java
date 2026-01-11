package datastructures.fundamentals;

import java.util.EmptyStackException;

/**
 * Stack Data Structure (LIFO).
 *
 * <p><strong>Best Use Case:</strong>
 * Undo mechanisms, expression parsing, backtracking algorithms (DFS), function call management.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Push: O(1)</li>
 *   <li>Pop: O(1)</li>
 *   <li>Peek: O(1)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(n)
 */
public class Stack<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public void push(T item) {
        Node<T> t = new Node<>(item);
        t.next = top;
        top = t;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
