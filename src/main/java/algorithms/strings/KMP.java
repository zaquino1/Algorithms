package algorithms.strings;

/**
 * Knuth-Morris-Pratt (KMP) Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * Substring search (pattern matching) in a text.
 * It avoids re-scanning characters in the text that have already been matched.
 *
 * <p><strong>Time Complexity:</strong> O(N + M) where N is text length, M is pattern length.
 * <p><strong>Space Complexity:</strong> O(M)
 */
public class KMP {
    void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;

        computeLPSArray(pat, M, lps);

        int i = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
}
