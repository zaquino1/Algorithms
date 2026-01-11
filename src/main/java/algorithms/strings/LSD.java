package algorithms.strings;

/**
 * Least Significant Digit (LSD) String Sort.
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 5.1).
 *
 * <p><strong>Best Use Case:</strong>
 * Sorting strings that are all the same length (e.g., license plates, IP addresses, bank account numbers).
 * Stable sort.
 *
 * <p><strong>Time Complexity:</strong> O(W * N) where W is fixed length.
 * <p><strong>Space Complexity:</strong> O(N + R) where R is alphabet size.
 */
public class LSD {
    public static void sort(String[] a, int w) {
        int n = a.length;
        int R = 256;   // extend ASCII alphabet size
        String[] aux = new String[n];

        for (int d = w - 1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++)
                count[a[i].charAt(d) + 1]++;

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            // move data
            for (int i = 0; i < n; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            // copy back
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }
}
