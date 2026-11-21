package Unit7.Graph.PrimsAlgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        int V = 6;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected weighted graph

        adj.get(0).add(new int[] { 1, 4 });
        adj.get(1).add(new int[] { 0, 4 });

        adj.get(0).add(new int[] { 3, 2 });
        adj.get(3).add(new int[] { 0, 2 });

        adj.get(0).add(new int[] { 2, 1 });
        adj.get(2).add(new int[] { 0, 1 });

        adj.get(1).add(new int[] { 2, 3 });
        adj.get(2).add(new int[] { 1, 3 });

        adj.get(1).add(new int[] { 4, 7 });
        adj.get(4).add(new int[] { 1, 7 });

        adj.get(2).add(new int[] { 4, 6 });
        adj.get(4).add(new int[] { 2, 6 });

        adj.get(2).add(new int[] { 5, 8 });
        adj.get(5).add(new int[] { 2, 8 });

        adj.get(3).add(new int[] { 5, 5 });
        adj.get(5).add(new int[] { 3, 5 });

        adj.get(5).add(new int[] { 4, 3 });
        adj.get(4).add(new int[] { 5, 3 });

        // Print graph
        for (int i = 0; i < V; i++) {

            System.out.print(i + " -> ");

            for (int[] edge : adj.get(i)) {
                System.out.print(
                        "(" + edge[0] + ", " + edge[1] + ") ");
            }

            System.out.println();

        }

        MST(adj);
    }

    public static void MST(ArrayList<ArrayList<int[]>> Graph) {
        boolean[] visited = new boolean[Graph.size()];

        // [0] -> weight;
        // [1] -> node
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        pq.offer(new int[] { 0, 0 });

        int totalCost = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];
            if (visited[u])
                continue;

            visited[u] = true;
            totalCost += curr[0];

            for (int[] neighbors : Graph.get(u)) {
                int v = neighbors[0];
                if (!visited[v]) {
                    pq.offer(new int[] { neighbors[1], v });
                }
            }
        }

        System.out.println(totalCost);
    }
}