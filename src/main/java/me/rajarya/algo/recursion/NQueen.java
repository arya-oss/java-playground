package me.rajarya.algo.recursion;

public class NQueen {
    private static final int N = 8;

    private static boolean isSafeRow(int[][] board, int c) {
        for (int r = 0; r < N; r++) {
            if (board[r][c] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSafeCol(int[][] board, int r) {
        for (int c = 0; c < N; c++) {
            if (board[r][c] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSafeDiagonal(int[][] board, int row, int col) {
        int r = row, c = col;
        while (r >=0 && r < N && c >= 0 && c < N) {
            if (board[r][c] == 1) return false;
            r++;
            c++;
        }
        r = row; c = col;
        while (r >=0 && r < N && c >= 0 && c < N) {
            if (board[r][c] == 1) return false;
            r--;
            c++;
        }
        r = row; c = col;
        while (r >=0 && r < N && c >= 0 && c < N) {
            if (board[r][c] == 1) return false;
            r++;
            c--;
        }
        r = row; c = col;
        while (r >=0 && r < N && c >= 0 && c < N) {
            if (board[r][c] == 1) return false;
            r--;
            c--;
        }
        return true;
    }

    private static boolean solve(int[][] board, int col) {
        if (col >= N) return true;
        for (int i = 0; i < N; i++) {
            if (isSafeRow(board, col) && isSafeCol(board, i) && isSafeDiagonal(board, i , col)) {
                board[i][col] = 1;
                if (solve(board, col+1)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        solve(board, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }
}
