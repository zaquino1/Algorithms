package datastructures.fundamentals;

/**
 * Singly Linked List with Reversal.
 *
 * <p><strong>Best Use Case:</strong>
 * Dynamic memory allocation, implementing stacks/queues, adjacency lists.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Insert at head: O(1)</li>
 *   <li>Search: O(n)</li>
 * </ul>
 */
public class SinglyLinkedList<T> {
    private class Node {
        T data;
        Node next;
        Node(T d) { data = d; next = null; }
    }
    
    private Node head;

    public void insert(T data) {
        Node newNode = new Node(data);
        if (head == null) { head = newNode; }
        else {
            Node last = head;
            while (last.next != null) last = last.next;
            last.next = newNode;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
