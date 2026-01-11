package algorithms.sorting.advanced;

/**
 * Merge Sort Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * General-purpose sorting, especially for linked lists or when stable sorting is required.
 * Good for large datasets that don't fit in memory (external sorting).
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(n log n)</li>
 *   <li>Average: O(n log n)</li>
 *   <li>Worst: O(n log n)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(n) (Requires auxiliary array)
 */
public class MergeSort {
    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
