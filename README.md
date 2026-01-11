# Modern Java Algorithms & Data Structures

A comprehensive collection of fundamental algorithms and data structures implemented in Java. This project serves as a reference for modern software engineering practices, interview preparation, and educational study, heavily inspired by *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.

## 🚀 Project Overview

This repository is organized into a clean, modular package structure that separates algorithms by type (Sorting, Searching, Graphs, Strings) and data structures by category (Fundamentals, Trees, Queues, etc.).

Each implementation includes Javadoc comments detailing:
- **Best Use Cases:** Real-world applications for the algorithm.
- **Time Complexity:** Best, Average, and Worst-case performance.
- **Space Complexity:** Memory usage requirements.

## 📂 Project Structure

### 1. Algorithms (`src/main/java/algorithms`)

#### 🔹 Sorting
- **Elementary:** Bubble Sort, Insertion Sort, Selection Sort.
- **Advanced:** 
  - **Merge Sort:** Stable, divide-and-conquer.
  - **Quick Sort:** In-place, fast average case.
  - **3-Way Quick Sort:** Optimized for duplicate keys (Dijkstra's Dutch National Flag).
  - **Heap Sort:** Memory efficient (O(1) extra space).
  - **Shell Sort:** Gap-based insertion sort.

#### 🔹 Searching
- **Binary Search:** O(log n) search on sorted arrays.
- **Linear Search:** Simple O(n) search.
- **Symbol Tables:** Sequential Search (Linked List implementation).

#### 🔹 Graphs
- **Undirected:** 
  - **DFS (Depth First Search):** Maze solving, connectivity.
  - **BFS (Breadth First Search):** Shortest path in unweighted graphs.
- **Directed:**
  - **Topological Sort:** Dependency resolution.
  - **Kosaraju's Algorithm:** Strongly Connected Components (SCC).
- **Minimum Spanning Trees (MST):**
  - **Kruskal's Algorithm:** Clustering, network design.
- **Shortest Paths:**
  - **Dijkstra's Algorithm:** Non-negative weights.
  - **Bellman-Ford Algorithm:** Handles negative weights and detects negative cycles.

#### 🔹 Strings
- **Sorting:**
  - **LSD (Least Significant Digit):** Fixed-length string sort.
  - **MSD (Most Significant Digit):** Variable-length string sort.
- **Searching:**
  - **Trie (Prefix Tree):** Autocomplete, spell checking.
  - **KMP (Knuth-Morris-Pratt):** Efficient substring search.
- **Compression:**
  - **Huffman Coding:** Lossless compression using frequency analysis.
  - **Run-Length Encoding (RLE):** Simple compression for repeated data.
- **Regular Expressions:**
  - **NFA (Nondeterministic Finite Automaton):** Regex compilation and matching engine.

#### 🔹 Techniques
- **Recursion:** Factorial calculation (Recursive vs. Iterative).
- **Dynamic Programming:** Fibonacci sequence (Memoization & Tabulation).

---

### 2. Data Structures (`src/main/java/datastructures`)

#### 🔹 Fundamentals
- **Lists:** Singly Linked List (with reversal), Doubly Linked List.
- **Collections:** Stack (LIFO), Queue (FIFO), Bag.
- **Union-Find:** Weighted Quick-Union with Path Compression.

#### 🔹 Trees
- **Binary Search Tree (BST):** Standard implementation.
- **AVL Tree:** Self-balancing BST.
- **Red-Black Tree:** Self-balancing BST (basis for Java's `TreeMap`).

#### 🔹 Hashing
- **Hash Map:** Custom implementation using chaining for collision resolution.

#### 🔹 Queues
- **Priority Queue:** Binary Heap implementation.

#### 🔹 Arrays
- **Dynamic Array:** Resizable array implementation (similar to `ArrayList`).

---

## 🛠️ How to Run

The project includes a comprehensive driver class `main.java` that runs demonstrations for every algorithm and data structure in the library.

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/algorithms-java.git
   ```
2. **Open in IntelliJ IDEA** (or any Java IDE).
3. **Run `main.java`:**
   - Navigate to `src/main/java/main.java`.
   - Right-click and select **Run 'main.main()'**.

You will see a structured output in the console demonstrating sorting results, graph traversals, search findings, and compression statistics.

## 📚 References

- **Algorithms, 4th Edition** by Robert Sedgewick and Kevin Wayne.
- **Introduction to Algorithms (CLRS)** by Cormen, Leiserson, Rivest, and Stein.

## 📝 License

This project is open-source and available for educational purposes.
