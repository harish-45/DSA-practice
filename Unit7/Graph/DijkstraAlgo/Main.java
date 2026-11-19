package Unit7.Graph.DijkstraAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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
        // create a undirected graph
        int v = 7;

        ArrayList<Edge>[] Graph1 = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            Graph1[i] = new ArrayList<>();
        }

        // Vertex 0
        Graph1[0].add(new Edge(0, 1, 2));
        Graph1[0].add(new Edge(0, 2, 4));

        // Vertex 1
        Graph1[1].add(new Edge(1, 0, 2));
        Graph1[1].add(new Edge(1, 3, 7));
        Graph1[1].add(new Edge(1, 4, 3));

        // Vertex 2
        Graph1[2].add(new Edge(2, 0, 4));
        Graph1[2].add(new Edge(2, 5, 5));
        Graph1[2].add(new Edge(2, 6, 1));

        // Vertex 3
        Graph1[3].add(new Edge(3, 1, 7));

        // Vertex 4
        Graph1[4].add(new Edge(4, 1, 3));

        // Vertex 5
        Graph1[5].add(new Edge(5, 2, 5));

        // Vertex 6
        Graph1[6].add(new Edge(6, 2, 1));

        // ...... for undirected graph
        DijkstraAlgo(v, Graph1, 5);

        /* create a directed Graph */
        int v2 = 7;

        ArrayList<Edge>[] Graph2 = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            Graph2[i] = new ArrayList<>();
        }

        // Vertex 0
        Graph2[0].add(new Edge(0, 1, 2));
        Graph2[0].add(new Edge(0, 2, 4));

        // Vertex 1
        Graph2[1].add(new Edge(1, 3, 7));
        Graph2[1].add(new Edge(1, 4, 3));

        // Vertex 2
        Graph2[2].add(new Edge(2, 5, 5));
        Graph2[2].add(new Edge(2, 6, 1));

        // Vertex 3
        // No outgoing edges

        // Vertex 4
        // No outgoing edges

        // Vertex 5
        // No outgoing edges

        // Vertex 6
        // No outgoing edges

        DijkstraAlgo(v2, Graph2, 2);

    }

    static class Pair {
        int Vertex;
        int dist;

        public Pair(int v, int d) {
            Vertex = v;
            dist = d;
        }
    }

    public static void DijkstraAlgo(int v, ArrayList<Edge>[] graph, int d) {
        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        // initialize distance with infinity
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Enqueue src -> 0
        distance[0] = 0;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (visited[curr.Vertex])
                continue;

            visited[curr.Vertex] = true;

            for (Edge neighbors : graph[curr.Vertex]) {
                int wt = neighbors.weight;
                int ver = neighbors.dest;

                if (distance[curr.Vertex] + wt < distance[ver]) {
                    distance[ver] = distance[curr.Vertex] + wt;
                    pq.offer(new Pair(ver, distance[ver]));
                }

                // ........ distance[ver] = Math.min(distance[ver], distance[curr.Vertex] + wt);

            }

        }

        System.out.println("Shortest distance Vertex '0' to '" + d + "' : " + distance[d]);

    }
}
