package Unit9.DP.Fibonacii.ClimbingStairs;

public class Main {
    // a person can jump 1 Or 2 stairs at a time;
    public static void main(String[] args) {
        int n = 5;
        // System.out.println(recursion(n));

        // System.out.println(memoization(n));

        // System.out.println(tabulation(n));

        System.out.println(climbingStairs(n));
    }

    public static int recursion(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        return recursion(n - 1) + recursion(n - 2);
    }

    static long[] dp;

    public static long memoization(int n) {
        dp = new long[n + 1];
        return cs(n);
    }

    public static long cs(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (dp[n] != 0)
            return dp[n];

        dp[n] = cs(n - 1) + cs(n - 2);

        return dp[n];
    }

    public static long tabulation(int n) {
        dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = dp[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 1,2,3 stairs allows
    public static long climbingStairs(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (n <= 2)
            return n;
        if (n == 3)
            return 4;

        dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = dp[0];
        dp[2] = dp[1] + dp[0];
        dp[3] = dp[1] + dp[2] + 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
