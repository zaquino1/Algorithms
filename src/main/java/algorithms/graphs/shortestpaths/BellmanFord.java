package algorithms.graphs.shortestpaths;

import java.util.Arrays;

/**
 * Bellman-Ford Algorithm.
 *
 * <p><strong>Best Use Case:</strong>
 * Finding shortest paths in graphs with negative edge weights.
 * Can detect negative cycles.
 *
 * <p><strong>Time Complexity:</strong> O(V * E)
 * <p><strong>Space Complexity:</strong> O(V)
 */
public class BellmanFord {
    class Edge {
        int src, dest, weight;
        Edge() { src = dest = weight = 0; }
    }

    int V, E;
    Edge edge[];

    public BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
    
    public void addEdge(int index, int src, int dest, int weight) {
        edge[index].src = src;
        edge[index].dest = dest;
        edge[index].weight = weight;
    }

    public void findShortestPath(int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Check for negative weight cycles
        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        
        printArr(dist);
    }

    void printArr(int dist[]) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}
