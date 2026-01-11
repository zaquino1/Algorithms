import algorithms.sorting.elementary.BubbleSort;
import algorithms.sorting.elementary.InsertionSort;
import algorithms.sorting.elementary.SelectionSort;
import algorithms.sorting.advanced.MergeSort;
import algorithms.sorting.advanced.QuickSort;
import algorithms.sorting.advanced.HeapSort;
import algorithms.sorting.advanced.ShellSort;
import algorithms.searching.BinarySearch;
import datastructures.fundamentals.Stack;
import datastructures.fundamentals.Queue;
import datastructures.fundamentals.Bag;
import algorithms.graphs.undirected.DepthFirstSearch;
import algorithms.graphs.undirected.BreadthFirstSearch;
import algorithms.graphs.directed.TopologicalSort;
import algorithms.graphs.minimumspanningtrees.KruskalMST;
import algorithms.graphs.shortestpaths.Dijkstra;
import algorithms.strings.Trie;
import algorithms.strings.KMP;
import datastructures.trees.BinarySearchTree;
import datastructures.trees.AVLTree;

public class main {
    public static void main(String[] args) {
        System.out.println("Modern Java Algorithms & Data Structures (2026 Edition)");
        System.out.println("=====================================================");

        // --- Sorting ---
        System.out.println("\n--- Sorting Algorithms ---");
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("1. Bubble Sort (Elementary)");
        BubbleSort bubbleSort = new BubbleSort();
        int[] bubbleArr = arr.clone();
        bubbleSort.sort(bubbleArr);
        printArray(bubbleArr);
        
        System.out.println("2. Insertion Sort (Elementary)");
        InsertionSort insertionSort = new InsertionSort();
        int[] insertArr = arr.clone();
        insertionSort.sort(insertArr);
        printArray(insertArr);

        System.out.println("3. Selection Sort (Elementary)");
        SelectionSort selectionSort = new SelectionSort();
        int[] selectArr = arr.clone();
        selectionSort.sort(selectArr);
        printArray(selectArr);

        System.out.println("4. Merge Sort (Advanced - Stable)");
        MergeSort mergeSort = new MergeSort();
        int[] mergeArr = arr.clone();
        mergeSort.sort(mergeArr, 0, mergeArr.length - 1);
        printArray(mergeArr);

        System.out.println("5. Quick Sort (Advanced - In-Place)");
        QuickSort quickSort = new QuickSort();
        int[] quickArr = arr.clone();
        quickSort.sort(quickArr, 0, quickArr.length - 1);
        printArray(quickArr);

        System.out.println("6. Heap Sort (Advanced - Memory Efficient)");
        HeapSort heapSort = new HeapSort();
        int[] heapArr = arr.clone();
        heapSort.sort(heapArr);
        printArray(heapArr);

        System.out.println("7. Shell Sort (Advanced - Gap Insertion)");
        ShellSort shellSort = new ShellSort();
        int[] shellArr = arr.clone();
        shellSort.sort(shellArr);
        printArray(shellArr);


        // --- Searching ---
        System.out.println("\n--- Searching Algorithms ---");
        System.out.println("1. Binary Search");
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(mergeArr, 25); // Using sorted array
        System.out.println("Found 25 at index: " + result);


        // --- Fundamentals ---
        System.out.println("\n--- Fundamental Data Structures ---");
        System.out.println("1. Stack (LIFO)");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Popped: " + stack.pop());

        System.out.println("2. Queue (FIFO)");
        Queue<String> queue = new Queue<>();
        queue.add("First");
        queue.add("Second");
        System.out.println("Removed: " + queue.remove());

        System.out.println("3. Bag (Collection)");
        Bag<Double> bag = new Bag<>();
        bag.add(1.5);
        bag.add(3.7);
        System.out.print("Bag contents: ");
        for (Double d : bag) {
            System.out.print(d + " ");
        }
        System.out.println();
        
        System.out.println("\n4. Binary Search Tree");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50); bst.insert(30); bst.insert(20); bst.insert(40); bst.insert(70);
        System.out.print("Inorder Traversal: ");
        bst.inorder();
        System.out.println();
        
        System.out.println("5. AVL Tree (Self-Balancing)");
        AVLTree avl = new AVLTree();
        avl.insert(10); avl.insert(20); avl.insert(30); avl.insert(40); avl.insert(50); avl.insert(25);
        System.out.print("Preorder Traversal: ");
        avl.preOrder(avl.getRoot());
        System.out.println();


        // --- Graphs ---
        System.out.println("\n--- Graph Algorithms ---");
        System.out.println("1. DFS (Undirected)");
        DepthFirstSearch dfs = new DepthFirstSearch(4);
        dfs.addEdge(0, 1); dfs.addEdge(0, 2); dfs.addEdge(1, 2); dfs.addEdge(2, 0); dfs.addEdge(2, 3); dfs.addEdge(3, 3);
        dfs.DFS(2);
        System.out.println();

        System.out.println("2. BFS (Undirected)");
        BreadthFirstSearch bfs = new BreadthFirstSearch(4);
        bfs.addEdge(0, 1); bfs.addEdge(0, 2); bfs.addEdge(1, 2); bfs.addEdge(2, 0); bfs.addEdge(2, 3); bfs.addEdge(3, 3);
        bfs.BFS(2);
        System.out.println();
        
        System.out.println("3. Topological Sort (Directed)");
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2); g.addEdge(5, 0); g.addEdge(4, 0); g.addEdge(4, 1); g.addEdge(2, 3); g.addEdge(3, 1);
        System.out.print("Topological Sort: ");
        g.sort();
        System.out.println();
        
        System.out.println("4. Kruskal's MST");
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        KruskalMST mst = new KruskalMST(V, E);
        mst.addEdge(0, 0, 1, 10);
        mst.addEdge(1, 0, 2, 6);
        mst.addEdge(2, 0, 3, 5);
        mst.addEdge(3, 1, 3, 15);
        mst.addEdge(4, 2, 3, 4);
        mst.MST();

        System.out.println("5. Dijkstra (Shortest Path)");
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 0);


        // --- Strings ---
        System.out.println("\n--- String Algorithms ---");
        System.out.println("1. Trie (Prefix Tree)");
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Search 'appl': " + trie.search("appl"));
        
        System.out.println("2. KMP (Substring Search)");
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP().KMPSearch(pat, txt);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
