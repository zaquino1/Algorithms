package algorithms.techniques.recursion;

/**
 * Factorial Calculation (Recursion vs Iteration).
 *
 * <p><strong>Concept:</strong>
 * A classic example of recursion where a function calls itself.
 * n! = n * (n-1) * ... * 1.
 *
 * <p><strong>Time Complexity:</strong> O(n)
 * <p><strong>Space Complexity:</strong>
 * <ul>
 *   <li>Recursive: O(n) (Stack depth)</li>
 *   <li>Iterative: O(1)</li>
 * </ul>
 */
public class Factorial {
    public long recursive(int n) {
        if (n <= 1) return 1;
        return n * recursive(n - 1);
    }

    public long iterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
