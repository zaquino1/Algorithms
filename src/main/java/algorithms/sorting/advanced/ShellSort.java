package algorithms.sorting.advanced;

/**
 * Shell Sort Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * Medium-sized arrays where a simple implementation is preferred over the overhead of O(n log n) algorithms.
 * It is an optimization of Insertion Sort.
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Best: O(n log n)</li>
 *   <li>Average: Depends on gap sequence (typically O(n^1.25) or O(n^1.5))</li>
 *   <li>Worst: O(n^2)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(1) (In-place)
 */
public class ShellSort {
    public void sort(int arr[]) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
    }
}
