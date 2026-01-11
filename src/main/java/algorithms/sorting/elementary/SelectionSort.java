package algorithms.sorting.elementary;

/**
 * Selection Sort Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * When memory writes are extremely expensive (flash memory), as it makes the minimum number of swaps (O(n)).
 * Generally outperformed by Insertion Sort.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(n^2)</li>
 *   <li>Average: O(n^2)</li>
 *   <li>Worst: O(n^2)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(1) (In-place)
 */
public class SelectionSort {
    public void sort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
