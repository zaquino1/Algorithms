package datastructures.queues;

import java.util.ArrayList;

/**
 * Priority Queue (Binary Heap Implementation).
 *
 * <p><strong>Best Use Case:</strong>
 * Dijkstra's algorithm, Prim's algorithm, Huffman coding, scheduling tasks by priority.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Insert: O(log n)</li>
 *   <li>Extract Max/Min: O(log n)</li>
 *   <li>Peek: O(1)</li>
 * </ul>
 */
public class PriorityQueueHeap {
    private ArrayList<Integer> heap;

    public PriorityQueueHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int key) {
        heap.add(key);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMax() {
        if (heap.size() == 0) return Integer.MIN_VALUE;
        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        maxHeapify(0);
        return max;
    }

    private void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < heap.size() && heap.get(left) > heap.get(largest))
            largest = left;
        if (right < heap.size() && heap.get(right) > heap.get(largest))
            largest = right;

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }
}
