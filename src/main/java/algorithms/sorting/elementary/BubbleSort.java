package algorithms.sorting.elementary;

/**
 * Bubble Sort Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * Educational purposes only. It is inefficient for large datasets.
 * Useful for very small, nearly sorted datasets or to detect if a list is already sorted.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(n) (when array is already sorted)</li>
 *   <li>Average: O(n^2)</li>
 *   <li>Worst: O(n^2)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(1) (In-place)
 */
public class BubbleSort {
    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }
}
