package algorithms.searching;

/**
 * Binary Search Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * Finding an element in a sorted array.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(1)</li>
 *   <li>Average: O(log n)</li>
 *   <li>Worst: O(log n)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(1) (Iterative)
 */
public class BinarySearch {
    public int search(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x) return m;
            if (arr[m] < x) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}
