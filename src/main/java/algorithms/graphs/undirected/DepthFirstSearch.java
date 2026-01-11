package algorithms.graphs.undirected;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Depth First Search (DFS) for Undirected Graphs.
 *
 * <p><strong>Best Use Case:</strong>
 * Maze solving, cycle detection, checking connectivity, topological sorting.
 *
 * <p><strong>Time Complexity:</strong> O(V + E)
 * <p><strong>Space Complexity:</strong> O(V)
 */
public class DepthFirstSearch {
    private int V;
    private LinkedList<Integer> adj[];

    public DepthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Undirected
    }

    public void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
}
