package algorithms.strings;

import java.util.Stack;
import java.util.ArrayList;

/**
 * Nondeterministic Finite Automaton (NFA) for Regular Expression Matching.
 *
 * <p><strong>Source:</strong> Algorithms 4th Edition, Sedgewick & Wayne (Section 5.4).
 *
 * <p><strong>Best Use Case:</strong>
 * Compiling and executing regular expressions. Supports concatenation, OR (|), and closure (*).
 *
 * <p><strong>Time Complexity:</strong> O(M * N) where M is regex length and N is text length.
 */
public class NFA {
    private char[] re;      // match transitions
    private Digraph G;      // epsilon transitions
    private int M;          // number of states

    // Inner class for a simple Digraph to avoid dependency cycles for this standalone example
    private class Digraph {
        private final int V;
        private final ArrayList<Integer>[] adj;

        public Digraph(int V) {
            this.V = V;
            adj = (ArrayList<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++)
                adj[v] = new ArrayList<Integer>();
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }

    public NFA(String regexp) {
        // Handle simple parentheses for grouping
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M + 1);

        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|')
                ops.push(i);
            else if (re[i] == ')') {
                int or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                } else lp = or;
            }

            if (i < M - 1 && re[i + 1] == '*') {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }

            if (re[i] == '(' || re[i] == '*' || re[i] == ')')
                G.addEdge(i, i + 1);
        }
    }

    public boolean recognizes(String txt) {
        ArrayList<Integer> pc = new ArrayList<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for (int v = 0; v < G.V; v++)
            if (dfs.marked[v]) pc.add(v);

        for (int i = 0; i < txt.length(); i++) {
            ArrayList<Integer> match = new ArrayList<>();
            for (int v : pc) {
                if (v < M) {
                    if (re[v] == txt.charAt(i) || re[v] == '.')
                        match.add(v + 1);
                }
            }
            pc = new ArrayList<>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V; v++)
                if (dfs.marked[v]) pc.add(v);
            
            if (pc.size() == 0) return false;
        }

        for (int v : pc)
            if (v == M) return true;
        return false;
    }

    // Helper DFS class
    private class DirectedDFS {
        private boolean[] marked;

        public DirectedDFS(Digraph G, int s) {
            marked = new boolean[G.V];
            dfs(G, s);
        }

        public DirectedDFS(Digraph G, Iterable<Integer> sources) {
            marked = new boolean[G.V];
            for (int s : sources)
                if (!marked[s]) dfs(G, s);
        }

        private void dfs(Digraph G, int v) {
            marked[v] = true;
            for (int w : G.adj(v))
                if (!marked[w]) dfs(G, w);
        }
    }
}
