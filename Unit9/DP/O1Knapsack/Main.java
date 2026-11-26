package Unit9.DP.O1Knapsack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(O1Knapsack(val, wt, W));

        printM();
    }

    static int[][] dp;

    public static int O1Knapsack(int[] val, int[] wt, int W) {
        int n = val.length;
        dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            int wal = val[i - 1];
            int vet = wt[i - 1];
            for (int j = 1; j <= W; j++) {
                // valid
                if (vet <= j) {
                    int include = wal + dp[i - 1][j - vet];

                    int exclude = dp[i - 1][j];

                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void printM() {
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
}
