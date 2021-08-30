package me.rajarya.algo.dp;

/**
 * We have a knapsack of weight w with items and their weights.
 */

public class KnapSack01 {
    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int W = 7;
        int ans = solve(values, weights, W);
        System.out.println(ans);
    }

    private static int solve(int[] values, int[] weights, int w) {
        int[][] lookup = new int[values.length + 1][w + 1];

        for (int i = 0; i <= values.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    lookup[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    lookup[i][j] = Math.max(lookup[i - 1][j], values[i - 1] + lookup[i - 1][j - weights[i - 1]]);
                } else {
                    lookup[i][j] = lookup[i - 1][j];
                }
            }
        }
        return lookup[values.length][w];
    }
}
