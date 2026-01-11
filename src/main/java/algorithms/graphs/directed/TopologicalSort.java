package algorithms.graphs.directed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Topological Sort for Directed Acyclic Graphs (DAG).
 *
 * <p><strong>Best Use Case:</strong>
 * Scheduling tasks with dependencies (e.g., build systems like Maven/Gradle),
 * resolving symbol dependencies in linkers.
 *
 * <p><strong>Time Complexity:</strong> O(V + E)
 * <p><strong>Space Complexity:</strong> O(V)
 */
public class TopologicalSort {
    private int V;
    private LinkedList<Integer> adj[];

    public TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        stack.push(new Integer(v));
    }

    public void sort() {
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }
}
