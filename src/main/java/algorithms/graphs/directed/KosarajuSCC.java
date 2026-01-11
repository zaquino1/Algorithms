package algorithms.graphs.directed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Kosaraju's Algorithm for Strongly Connected Components (SCC).
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 4.2).
 *
 * <p><strong>Best Use Case:</strong>
 * Finding strongly connected components in a directed graph.
 * Useful for analyzing web graph structure, ecological food webs.
 *
 * <p><strong>Time Complexity:</strong> O(V + E) (Two DFS passes)
 * <p><strong>Space Complexity:</strong> O(V)
 */
public class KosarajuSCC {
    private int V;
    private LinkedList<Integer> adj[];

    public KosarajuSCC(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Fills Stack with vertices (in increasing order of finishing times)
    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(new Integer(v));
    }

    // Returns transpose of this graph
    KosarajuSCC getTranspose() {
        KosarajuSCC g = new KosarajuSCC(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public void printSCCs() {
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);

        KosarajuSCC gr = getTranspose();

        for (int i = 0; i < V; i++)
            visited[i] = false;

        while (stack.empty() == false) {
            int v = (int) stack.pop();
            if (visited[v] == false) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }
}
