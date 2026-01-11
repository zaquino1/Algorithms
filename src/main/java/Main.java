public class Main {
    public static void main(String[] args) {
        System.out.println("Algorithms & Data Structures Project");
        System.out.println("------------------------------------");

        System.out.println("\n--- Sorting Algorithms ---");
        System.out.println("Running Bubble Sort:");
        BubbleSort.main(args);
        System.out.println("\n\nRunning Merge Sort:");
        MergeSort.main(args);
        System.out.println("\n\nRunning Quick Sort:");
        QuickSort.main(args);
        System.out.println("\n\nRunning Insertion Sort:");
        InsertionSort.main(args);
        System.out.println("\n\nRunning Selection Sort:");
        SelectionSort.main(args);

        System.out.println("\n\n--- Searching Algorithms ---");
        System.out.println("Running Binary Search:");
        BinarySearch.main(args);

        System.out.println("\n\n--- Graph Algorithms ---");
        System.out.println("Running Depth First Search:");
        DepthFirstSearch.main(args);
        System.out.println("\n\nRunning Breadth First Search:");
        BreadthFirstSearch.main(args);
        System.out.println("\n\nRunning Dijkstra's Algorithm:");
        Dijkstra.main(args);

        System.out.println("\n\n--- Data Structures ---");
        System.out.println("Running Singly Linked List:");
        SinglyLinkedList.main(args);
        System.out.println("\nRunning Stack (Array Implementation):");
        StackArray.main(args);
        System.out.println("\nRunning Queue (Array Implementation):");
        QueueArray.main(args);
        System.out.println("\nRunning Binary Tree Traversal:");
        BinaryTree.main(args);
        System.out.println("\n\nRunning Binary Search Tree:");
        BinarySearchTree.main(args);
        System.out.println("\n\nRunning Hash Table:");
        HashTable.main(args);
        System.out.println("\nRunning Min Heap:");
        Heap.main(args);
    }
}
