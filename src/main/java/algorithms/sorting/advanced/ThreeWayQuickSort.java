package algorithms.sorting.advanced;

/**
 * 3-Way QuickSort (Dijkstra's Dutch National Flag problem).
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 2.3).
 *
 * <p><strong>Best Use Case:</strong>
 * Sorting arrays with many duplicate keys. It is much faster than standard QuickSort
 * in these cases (O(N) time).
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(N) (All keys equal)</li>
 *   <li>Average: O(N log N)</li>
 *   <li>Worst: O(N^2)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(log N) (Recursion stack)
 */
public class ThreeWayQuickSort {
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            if      (a[i] < v) exch(a, lt++, i++);
            else if (a[i] > v) exch(a, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
