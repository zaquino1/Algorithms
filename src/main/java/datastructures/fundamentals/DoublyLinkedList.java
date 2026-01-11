package datastructures.fundamentals;

/**
 * Doubly Linked List.
 *
 * <p><strong>Best Use Case:</strong>
 * Navigation systems (browser history forward/back), music players (next/prev song),
 * implementing Deques (Double-ended queues).
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Insert/Delete at ends: O(1)</li>
 *   <li>Search: O(n)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(n) (Extra pointer for 'prev')
 */
public class DoublyLinkedList<T> {
    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T d) {
            data = d;
        }
    }

    private Node head;

    public void push(T new_data) {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        new_Node.prev = null;
        if (head != null)
            head.prev = new_Node;
        head = new_Node;
    }

    public void append(T new_data) {
        Node new_Node = new Node(new_data);
        Node last = head;
        new_Node.next = null;
        if (head == null) {
            new_Node.prev = null;
            head = new_Node;
            return;
        }
        while (last.next != null)
            last = last.next;
        last.next = new_Node;
        new_Node.prev = last;
    }

    public void printList(boolean forward) {
        Node node = head;
        Node last = null;
        System.out.print("Traversal: ");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        if (!forward && last != null) {
            System.out.print("| Reverse: ");
            while (last != null) {
                System.out.print(last.data + " ");
                last = last.prev;
            }
        }
        System.out.println();
    }

    public void reverse() {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
}
