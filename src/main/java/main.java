import algorithms.sorting.elementary.BubbleSort;
import algorithms.sorting.elementary.InsertionSort;
import algorithms.sorting.elementary.SelectionSort;
import algorithms.sorting.advanced.MergeSort;
import algorithms.sorting.advanced.QuickSort;
import algorithms.sorting.advanced.ThreeWayQuickSort;
import algorithms.sorting.advanced.HeapSort;
import algorithms.sorting.advanced.ShellSort;
import algorithms.searching.BinarySearch;
import algorithms.searching.LinearSearch;
import algorithms.searching.SequentialSearchST;
import algorithms.techniques.recursion.Factorial;
import algorithms.techniques.dynamicprogramming.Fibonacci;
import datastructures.fundamentals.Stack;
import datastructures.fundamentals.Queue;
import datastructures.fundamentals.Bag;
import datastructures.fundamentals.SinglyLinkedList;
import datastructures.fundamentals.DoublyLinkedList;
import datastructures.fundamentals.UnionFind;
import datastructures.hashing.HashMap;
import datastructures.arrays.DynamicArray;
import datastructures.queues.PriorityQueueHeap;
import algorithms.graphs.undirected.DepthFirstSearch;
import algorithms.graphs.undirected.BreadthFirstSearch;
import algorithms.graphs.directed.TopologicalSort;
import algorithms.graphs.directed.KosarajuSCC;
import algorithms.graphs.minimumspanningtrees.KruskalMST;
import algorithms.graphs.shortestpaths.Dijkstra;
import algorithms.graphs.shortestpaths.BellmanFord;
import algorithms.strings.Trie;
import algorithms.strings.KMP;
import algorithms.strings.LSD;
import algorithms.strings.MSD;
import algorithms.strings.Huffman;
import algorithms.strings.RunLengthEncoding;
import algorithms.strings.NFA;
import datastructures.trees.BinarySearchTree;
import datastructures.trees.AVLTree;
import datastructures.trees.RedBlackTree;

public class main {
    public static void main(String[] args) {
        System.out.println("Modern Java Algorithms & Data Structures (Sedgewick 4th Ed. Inspired)");
        System.out.println("=====================================================================");

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
        
        System.out.println("6. 3-Way Quick Sort (Advanced - Duplicate Keys)");
        ThreeWayQuickSort threeWay = new ThreeWayQuickSort();
        int[] threeWayArr = {2, 1, 2, 3, 2, 1, 3, 2};
        threeWay.sort(threeWayArr);
        printArray(threeWayArr);

        System.out.println("7. Heap Sort (Advanced - Memory Efficient)");
        HeapSort heapSort = new HeapSort();
        int[] heapArr = arr.clone();
        heapSort.sort(heapArr);
        printArray(heapArr);

        System.out.println("8. Shell Sort (Advanced - Gap Insertion)");
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
        
        System.out.println("2. Linear Search");
        LinearSearch linearSearch = new LinearSearch();
        int linResult = linearSearch.search(arr, 22); // Using unsorted array
        System.out.println("Found 22 at index: " + linResult);
        
        System.out.println("3. Sequential Search Symbol Table");
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("A", 1); st.put("B", 2);
        System.out.println("Value for A: " + st.get("A"));


        // --- Techniques ---
        System.out.println("\n--- Algorithm Techniques ---");
        System.out.println("1. Recursion vs Iteration (Factorial)");
        Factorial fact = new Factorial();
        System.out.println("Recursive 5!: " + fact.recursive(5));
        System.out.println("Iterative 5!: " + fact.iterative(5));
        
        System.out.println("2. Dynamic Programming (Fibonacci)");
        Fibonacci fib = new Fibonacci();
        System.out.println("Fib(10) Tabulation: " + fib.tabulation(10));


        // --- Fundamentals ---
        System.out.println("\n--- Fundamental Data Structures ---");
        System.out.println("1. Union-Find (Weighted Quick Union)");
        UnionFind uf = new UnionFind(10);
        uf.union(4, 3); uf.union(3, 8); uf.union(6, 5);
        System.out.println("4 and 8 connected? " + uf.connected(4, 8));
        
        System.out.println("2. Stack (LIFO)");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Popped: " + stack.pop());

        System.out.println("3. Queue (FIFO)");
        Queue<String> queue = new Queue<>();
        queue.add("First");
        queue.add("Second");
        System.out.println("Removed: " + queue.remove());
        
        System.out.println("4. Priority Queue (Binary Heap)");
        PriorityQueueHeap pq = new PriorityQueueHeap();
        pq.insert(10); pq.insert(50); pq.insert(20);
        System.out.println("Max Priority: " + pq.extractMax());

        System.out.println("5. Bag (Collection)");
        Bag<Double> bag = new Bag<>();
        bag.add(1.5);
        bag.add(3.7);
        System.out.print("Bag contents: ");
        for (Double d : bag) {
            System.out.print(d + " ");
        }
        System.out.println();
        
        System.out.println("\n6. Dynamic Array (ArrayList)");
        DynamicArray<Integer> dArray = new DynamicArray<>(2);
        dArray.add(1); dArray.add(2); dArray.add(3); // Triggers resize
        System.out.println("Dynamic Array Size: " + dArray.size());
        
        System.out.println("7. Singly Linked List (with Reversal)");
        SinglyLinkedList<Integer> sList = new SinglyLinkedList<>();
        sList.insert(1); sList.insert(2); sList.insert(3);
        System.out.print("Original: "); sList.printList();
        sList.reverse();
        System.out.print("Reversed: "); sList.printList();
        
        System.out.println("8. Doubly Linked List");
        DoublyLinkedList<String> dList = new DoublyLinkedList<>();
        dList.append("A"); dList.append("B"); dList.append("C");
        dList.printList(true); // Forward and Reverse check
        
        System.out.println("9. Hash Map (Custom)");
        HashMap<String, Integer> map = new HashMap<>(10);
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println("Value for 'One': " + map.get("One"));
        
        System.out.println("\n10. Binary Search Tree");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50); bst.insert(30); bst.insert(20); bst.insert(40); bst.insert(70);
        System.out.print("Inorder Traversal: ");
        bst.inorder();
        System.out.println();
        
        System.out.println("11. AVL Tree (Self-Balancing)");
        AVLTree avl = new AVLTree();
        avl.insert(10); avl.insert(20); avl.insert(30); avl.insert(40); avl.insert(50); avl.insert(25);
        System.out.print("Preorder Traversal: ");
        avl.preOrder(avl.getRoot());
        System.out.println();
        
        System.out.println("12. Red-Black Tree");
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(10); rbt.insert(20); rbt.insert(30);
        System.out.print("Inorder Traversal: ");
        rbt.inorder();
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
        
        System.out.println("4. Kosaraju's SCC (Strongly Connected Components)");
        KosarajuSCC scc = new KosarajuSCC(5);
        scc.addEdge(1, 0); scc.addEdge(0, 2); scc.addEdge(2, 1); scc.addEdge(0, 3); scc.addEdge(3, 4);
        System.out.println("SCCs:");
        scc.printSCCs();
        
        System.out.println("5. Kruskal's MST");
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        KruskalMST mst = new KruskalMST(V, E);
        mst.addEdge(0, 0, 1, 10);
        mst.addEdge(1, 0, 2, 6);
        mst.addEdge(2, 0, 3, 5);
        mst.addEdge(3, 1, 3, 15);
        mst.addEdge(4, 2, 3, 4);
        mst.MST();

        System.out.println("6. Dijkstra (Shortest Path - Non-Negative)");
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
        
        System.out.println("\n7. Bellman-Ford (Shortest Path - Negative Weights)");
        int V_bf = 5;
        int E_bf = 8;
        BellmanFord bf = new BellmanFord(V_bf, E_bf);
        bf.addEdge(0, 0, 1, -1);
        bf.addEdge(1, 0, 2, 4);
        bf.addEdge(2, 1, 2, 3);
        bf.addEdge(3, 1, 3, 2);
        bf.addEdge(4, 1, 4, 2);
        bf.addEdge(5, 3, 2, 5);
        bf.addEdge(6, 3, 1, 1);
        bf.addEdge(7, 4, 3, -3);
        bf.findShortestPath(0);


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
        
        System.out.println("3. LSD String Sort (Fixed Length)");
        String[] lsdArr = {"4PGC938", "2IYE230", "3CIO720", "1ICK750", "1OHV845", "4JZY524", "1ICK750", "3CIO720", "1OHV845", "1OHV845", "2RLA629", "2RLA629", "3ATW723"};
        LSD.sort(lsdArr, 7);
        System.out.println("Sorted: " + lsdArr[0] + ", " + lsdArr[1] + "...");
        
        System.out.println("4. MSD String Sort (Variable Length)");
        String[] msdArr = {"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she", "sells", "are", "surely", "seashells"};
        MSD.sort(msdArr);
        System.out.println("Sorted: " + msdArr[0] + ", " + msdArr[1] + "...");
        
        System.out.println("5. Huffman Compression");
        Huffman.compress("it was the best of times it was the worst of times");
        
        System.out.println("\n6. Run-Length Encoding");
        String rleInput = "AAAABBBCCDAA";
        String rleCompressed = RunLengthEncoding.compress(rleInput);
        System.out.println("Original: " + rleInput);
        System.out.println("Compressed: " + rleCompressed);
        System.out.println("Expanded: " + RunLengthEncoding.expand(rleCompressed));
        
        System.out.println("\n7. NFA (Regular Expression Matching)");
        String regexp = "((A*B|AC)D)";
        NFA nfa = new NFA(regexp);
        System.out.println("Regex: " + regexp);
        System.out.println("Matches 'AABD': " + nfa.recognizes("AABD"));
        System.out.println("Matches 'ACD': " + nfa.recognizes("ACD"));
        System.out.println("Matches 'BD': " + nfa.recognizes("BD"));
        System.out.println("Matches 'AAA': " + nfa.recognizes("AAA"));
    }

    private static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
