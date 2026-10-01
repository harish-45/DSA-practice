package Unit3.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class KnightTourS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = knightTour(7);
        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }
    }

    // generates only one posible solution;
    public static ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int count = 0;
        int[][] board = new int[n][n];

        for (int[] b : board) {
            Arrays.fill(b, -1);
        }
        // prevents from zero check;
        board[0][0] = 0;
        knightTour(n, ans, count + 1, board, 0, 0);
        return ans;
    }

    public static boolean knightTour(int n, ArrayList<ArrayList<Integer>> ans, int count, int[][] board, int row,
            int col) {
        if (count == n * n) {
            for (int[] b : board) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i : b) {
                    list.add(i);
                }
                ans.add(list);
            }
            return true;
        }

        // checks up
        if (row - 2 >= 0) {
            // checks up- left
            if (col - 1 >= 0 && isSafe(board, row - 2, col - 1)) {
                board[row - 2][col - 1] = count;
                if (knightTour(n, ans, count + 1, board, row - 2, col - 1))
                    return true;
                board[row - 2][col - 1] = -1;
            }

            // checks up - right
            if (col + 1 < n && isSafe(board, row - 2, col + 1)) {
                board[row - 2][col + 1] = count;
                if (knightTour(n, ans, count + 1, board, row - 2, col + 1))
                    return true;
                board[row - 2][col + 1] = -1;
            }
        }

        // checks down
        if (row + 2 < n) {
            // checks down - left
            if (col - 1 >= 0 && isSafe(board, row + 2, col - 1)) {
                board[row + 2][col - 1] = count;
                if (knightTour(n, ans, count + 1, board, row + 2, col - 1))
                    return true;
                board[row + 2][col - 1] = -1;
            }

            // checks down - right
            if (col + 1 < n && isSafe(board, row + 2, col + 1)) {
                board[row + 2][col + 1] = count;
                if (knightTour(n, ans, count + 1, board, row + 2, col + 1))
                    return true;
                ;
                board[row + 2][col + 1] = -1;
            }
        }

        // checks left
        if (col - 2 >= 0) {
            // checks left - up
            if (row - 1 >= 0 && isSafe(board, row - 1, col - 2)) {
                board[row - 1][col - 2] = count;
                if (knightTour(n, ans, count + 1, board, row - 1, col - 2))
                    return true;
                board[row - 1][col - 2] = -1;
            }

            // checks left- Down
            if (row + 1 < n && isSafe(board, row + 1, col - 2)) {
                board[row + 1][col - 2] = count;
                if (knightTour(n, ans, count + 1, board, row + 1, col - 2))
                    return true;

                board[row + 1][col - 2] = -1;
            }
        }

        // checks right
        if (col + 2 < n) {
            // checks right- up
            if (row - 1 >= 0 && isSafe(board, row - 1, col + 2)) {
                board[row - 1][col + 2] = count;
                if (knightTour(n, ans, count + 1, board, row - 1, col + 2))
                    return true;
                board[row - 1][col + 2] = -1;
            }

            // checks right - Down
            if (row + 1 < n && isSafe(board, row + 1, col + 2)) {
                board[row + 1][col + 2] = count;
                if (knightTour(n, ans, count + 1, board, row + 1, col + 2))
                    return true;

                board[row + 1][col + 2] = -1;
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        return board[row][col] == -1;
    }
}