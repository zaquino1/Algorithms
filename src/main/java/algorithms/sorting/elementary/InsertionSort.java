package algorithms.sorting.elementary;

/**
 * Insertion Sort Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * Small datasets or arrays that are already substantially sorted.
 * It is stable and efficient for small data (low overhead).
 * Used as the base case for advanced algorithms like QuickSort or MergeSort.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(n) (Already sorted)</li>
 *   <li>Average: O(n^2)</li>
 *   <li>Worst: O(n^2)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(1) (In-place)
 */
public class InsertionSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
