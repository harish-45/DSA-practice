package Unit7.Graph.PrimsAlgo.ConnectingCities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] cities = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };

        System.out.println(ConnectCities(cities));
    }

    static class Edge {
        int v;
        int wt;

        public Edge(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static int ConnectCities(int[][] cities) {
        int totalCost = 0;
        int V = cities.length;

        ArrayList<Edge>[] Graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            Graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (cities[i][j] != 0)
                    Graph[i].add(new Edge(j, cities[i][j]));
                // Graph[i].add(new int[] { j, cities[i][j] });
            }
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];

            if (visited[u])
                continue;

            visited[u] = true;
            totalCost += curr[0];

            for (Edge neighbors : Graph[u]) {

                int v = neighbors.v;

                if (!visited[v]) {
                    pq.offer(new int[] { neighbors.wt, v });
                }
            }
        }
        return totalCost;
    }
}
