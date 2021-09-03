package me.rajarya.algo.recursion;

public class SudokuSolver {
    static final int N = 9;

    public static void main(String[] args) {
        short[][] board = new short[N][N];
        if (solve(board, 0, 0)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solutions exist!");
        }
    }

    private static boolean solve(short[][] board, int r, int c) {
        if (r == N - 1 && c == N) return true;
        if (c == N) {
            r++;
            c = 0;
        }
        if(board[r][c] != 0) return solve(board, r, c+1);
        for (short i = 1; i <= N; i++) {
            if (isSafe(board, r, c, i)) {
                board[r][c] = i;
                if (solve(board, r, c+1)) return true;
            }
            board[r][c] = 0;
        }
        return false;
    }

    private static boolean isSafe(short[][] board, int r, int c, short i) {
        for (int j = 0; j < N; j++) {
            if (board[r][j] == i)
                return false;
        }
        for (int j = 0; j < N; j++) {
            if (board[j][c] == i)
                return false;
        }
        int startR = r - r % 3;
        int startC = c - c % 3;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if(board[j+startR][k+startC] == i)
                    return false;
            }
        }
        return true;
    }
}
