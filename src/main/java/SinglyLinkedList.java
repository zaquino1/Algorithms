public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }
    Node head;
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = newNode; }
        else {
            Node last = head;
            while (last.next != null) last = last.next;
            last.next = newNode;
        }
    }
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1); list.insert(2); list.insert(3);
        System.out.print("LinkedList: ");
        list.printList();
    }
}

//important list traversal insert delete search
