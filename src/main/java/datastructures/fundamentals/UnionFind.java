package datastructures.fundamentals;

/**
 * Union-Find (Disjoint Set Union) - Weighted Quick Union with Path Compression.
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 1.5).
 *
 * <p><strong>Best Use Case:</strong>
 * Dynamic connectivity problems, Kruskal's MST algorithm, percolation in physics,
 * image processing (labeling connected components).
 *
 * <p><strong>Time Complexity:</strong>
 * <ul>
 *   <li>Initialize: O(N)</li>
 *   <li>Union: O(log N) (nearly constant, amortized inverse Ackermann function)</li>
 *   <li>Find: O(log N) (nearly constant)</li>
 * </ul>
 *
 * <p><strong>Space Complexity:</strong> O(N)
 */
public class UnionFind {
    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of elements in subtree rooted at i
    private int count;      // number of components

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }
}
