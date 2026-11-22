package Unit7.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public static ArrayList<Integer> DFS(ArrayList<Edge>[] Graph, int start) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[Graph.length];
        DFS(Graph, visited, ans, start);
        return ans;
    }

    public static void DFS(ArrayList<Edge>[] Graph, boolean[] visited, ArrayList<Integer> list, int start) {
        int size = Graph[start].size();
        list.add(start);
        visited[start] = true;
        for (int i = 0; i < size; i++) {
            int v = Graph[start].get(i).dest;
            if (!visited[v]) {
                DFS(Graph, visited, list, v);
            }
        }
    }

    public static ArrayList<Integer> BFS(ArrayList<Edge>[] Graph, int start) {
        boolean[] visited = new boolean[Graph.length];
        ArrayList<Integer> list = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            list.add(curr);

            for (int i = 0; i < Graph[curr].size(); i++) {
                int neighbors = Graph[curr].get(i).dest;

                if (!visited[neighbors]) {
                    q.add(neighbors);
                    visited[neighbors] = true;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int v = 7;

        ArrayList<Edge>[] Graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            Graph[i] = new ArrayList<>();
        }

        // Vertex 0
        Graph[0].add(new Edge(0, 1, 2));
        Graph[0].add(new Edge(0, 2, 4));

        // Vertex 1
        Graph[1].add(new Edge(1, 0, 2));
        Graph[1].add(new Edge(1, 3, 7));
        Graph[1].add(new Edge(1, 4, 3));

        // Vertex 2
        Graph[2].add(new Edge(2, 0, 4));
        Graph[2].add(new Edge(2, 5, 5));
        Graph[2].add(new Edge(2, 6, 1));

        // Vertex 3
        Graph[3].add(new Edge(3, 1, 7));

        // Vertex 4
        Graph[4].add(new Edge(4, 1, 3));

        // Vertex 5
        Graph[5].add(new Edge(5, 2, 5));

        // Vertex 6
        Graph[6].add(new Edge(6, 2, 1));

        System.out.println("BFS: " + BFS(Graph, 0));
        System.out.println("DFS: " + DFS(Graph, 0));
    }
}