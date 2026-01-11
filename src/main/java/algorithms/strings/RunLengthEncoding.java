package algorithms.strings;

/**
 * Run-Length Encoding (RLE).
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 5.5).
 *
 * <p><strong>Best Use Case:</strong>
 * Compressing data with long runs of repeated characters (e.g., simple bitmaps, biological sequences).
 *
 * <p><strong>Time Complexity:</strong> O(N)
 */
public class RunLengthEncoding {
    public static String compress(String txt) {
        StringBuilder sb = new StringBuilder();
        int n = txt.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && txt.charAt(i) == txt.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(txt.charAt(i));
            sb.append(count);
        }
        return sb.toString();
    }

    public static String expand(String txt) {
        StringBuilder sb = new StringBuilder();
        int n = txt.length();
        for (int i = 0; i < n; i++) {
            char c = txt.charAt(i);
            i++;
            if (i < n) {
                // Assuming single digit count for simplicity in this demo
                // In a real binary RLE, counts are handled differently
                int count = Character.getNumericValue(txt.charAt(i));
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
