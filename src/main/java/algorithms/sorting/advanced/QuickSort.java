package algorithms.sorting.advanced;

/**
 * Quick Sort Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * General-purpose in-memory sorting. Often faster in practice than MergeSort for arrays
 * due to better cache locality. Not stable.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(n log n)</li>
 *   <li>Average: O(n log n)</li>
 *   <li>Worst: O(n^2) (rare with good pivot selection)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(log n) (Recursion stack)
 */
public class QuickSort {
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
