package Unit7.Graph.DisjointSet;

public class Main {
    /*
     * static int n = 7;
     * static int[] parent = new int[n];
     * static int[] rank = new int[n];
     * 
     * static void intit() {
     * for (int i = 0; i < n; i++) {
     * parent[i] = i;
     * }
     * }
     * 
     * public static int find(int x) {
     * if (x == parent[x])
     * return x;
     * return find(parent[x]);
     * }
     * 
     * public static void union(int u, int v) {
     * int parA = find(u);
     * int parB = find(v);
     * 
     * if (rank[parA] == rank[parB]) {
     * parent[parB] = parA;
     * rank[parA]++;
     * } else if (rank[parA] < rank[parB]) {
     * parent[parA] = parB;
     * } else {
     * parent[parB] = parA;
     * }
     * 
     * }
     */

    static class DSU {
        int n;
        int[] parent;
        int[] rank;

        public DSU(int n) {
            this.n = n;

            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // find with path compresion
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int u, int v) {
            int parA = find(u);
            int parB = find(v);
            if (parA == parB)
                return;
            if (rank[parA] < rank[parB]) {
                parent[parA] = parB;
            } else if (rank[parA] > rank[parB]) {
                parent[parB] = parA;
            } else {

                // check the smallest parent so the lexographical order remains correct
                if (parA < parB) {
                    parent[parB] = parA;
                    rank[parA]++;
                } else {
                    parent[parA] = parB;
                    rank[parB]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(7);

        dsu.union(1, 3);
        System.out.println(dsu.find(3));
        dsu.union(2, 4);
        dsu.union(3, 6);
        dsu.union(1, 4);
        System.out.println(dsu.find(3));
        System.out.println(dsu.find(0));

    }

}
