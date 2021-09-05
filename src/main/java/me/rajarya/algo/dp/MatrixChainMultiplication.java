package me.rajarya.algo.dp;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] dims = {40, 20, 30, 10, 30};
        try {
            int ans = solve(dims, dims.length);
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int solve(int[] dims, int length) {
        int[][] lookup = new int[length][length];
        for (int i = 1; i < length; i++) {
            lookup[i][i] = 0;
        }

        int j;

        for (int L = 2; L < length; L++) {
            for (int i = 1; i < length - L + 1; i++) {
                j = i + L - 1;
                if (j == length) continue;
                lookup[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = lookup[i][k] + lookup[k+1][j]
                            + dims[i-1] * dims[k] * dims[j];
                    lookup[i][j] = Math.min(lookup[i][j], cost);
                    System.out.println("L: " + L + ", i: " + i + ", j: " + j + ", k: " + k);
                    print(lookup);
                }
            }
        }

        return lookup[1][length - 1];
    }

    private static void print(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                System.out.print("    " + arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
