package Unit7.Graph.BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static class Edge {
        int val;
        int dest;
        int weight;

        public Edge(int val, int dest, int weight) {
            this.val = val;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        int v = 7;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));

        edges.add(new Edge(1, 3, 7));
        edges.add(new Edge(1, 4, 3));

        edges.add(new Edge(2, 5, 5));
        edges.add(new Edge(2, 6, 1));

        edges.add(new Edge(3, 5, -2));

        edges.add(new Edge(4, 5, 2));

        edges.add(new Edge(6, 5, 3));

        BellmanFord(v, edges, 5);
    }

    public static void BellmanFord(int v, ArrayList<Edge> edges, int d) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (Edge E : edges) {
                if (dist[E.val] != Integer.MAX_VALUE && E.weight + dist[E.val] < dist[E.dest]) {
                    dist[E.dest] = E.weight + dist[E.val];
                }
            }
        }

        System.out.println(dist[d]);
    }
}
