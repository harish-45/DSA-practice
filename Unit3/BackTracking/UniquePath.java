package Unit3.BackTracking;

public class UniquePath {
    public static void main(String[] args) {
        int ans = uniquePaths(3, 2);
        System.out.println(ans);
    }

    public static int uniquePaths(int m, int n) {
        return uniquePaths(m, n, 0, 0);
    }

    public static int uniquePaths(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        int down = 0;
        int right = 0;

        if (i < m - 1) {
            down = uniquePaths(m, n, i + 1, j);
        }
        if (j < n - 1) {
            right = uniquePaths(m, n, i, j + 1);
        }
        return down + right;
    }
}
