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

// I have been solved questions based on backtracking in following sequence :
// find subset ( code - Myself)
// find permutation ( Myself)
// N Queens ( lecture )
// N Queens II ( Myself )
// Knight Tours ( Myself )
// Grid Illumination ( Attempted )
// Grid Ways (lecture to understand problem )
// sudoku
// Rat in a maze ( Intuition + code )
// keypad combination (not able to think how can I solve it using Backtracking).

// 1. I can't determine time complexity of these problem' s Solution ( like 2^n
// , 4^n , 8^n)
// 2. want to explore more problems on Backtracking
// 3. I am not taking live lecture ( Last 5 lecture ) this
// 4. I solved 45 - 50 problems this months on Leetcode or GFG ( easy to
// medium). ( total 100+ problems solved on LC ) but when someone ask to explain
// I can't.
