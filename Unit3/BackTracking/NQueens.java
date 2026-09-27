package Unit3.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];

        // initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();

        nQueens(n, 0, board, ans);

        System.out.println(ans);
    }

    public static void nQueens(int n, int row, char[][] board, List<List<String>> ans) {
        if (row == n) {
            List<String> list = makeList(board, ans);
            ans.add(list);
            print2DArray(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nQueens(n, row + 1, board, ans);// Recursive call
                board[row][col] = '.'; // BackTracking Steps
            }
        }
    }

    private static List<String> makeList(char[][] board, List<List<String>> ans) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }

        return list;
    }

    public static boolean isSafe(char[][] board, int row, int col) {

        // vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        // diagnally left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagnally right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void print2DArray(char[][] arr) {
        System.out.println("----------- BOARD ----------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

}
