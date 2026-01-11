package algorithms.techniques.dynamicprogramming;

/**
 * Fibonacci Sequence (Dynamic Programming).
 *
 * <p><strong>Concept:</strong>
 * Optimization of recursion by storing results of subproblems (Memoization or Tabulation).
 *
 * <p><strong>Time Complexity:</strong> O(n)
 * <p><strong>Space Complexity:</strong> O(n) (can be optimized to O(1) with tabulation)
 */
public class Fibonacci {
    // Memoization (Top-Down)
    public long memoization(int n, long[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = memoization(n - 1, memo) + memoization(n - 2, memo);
        return memo[n];
    }

    // Tabulation (Bottom-Up)
    public long tabulation(int n) {
        if (n <= 1) return n;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
