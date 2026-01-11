package algorithms.searching;

/**
 * Linear Search Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * Small or unsorted datasets. It is the only option if the data is not sorted
 * and we cannot afford the cost of sorting it first.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(1) (Found at first position)</li>
 *   <li>Average: O(n)</li>
 *   <li>Worst: O(n)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(1)
 */
public class LinearSearch {
    public int search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
}
