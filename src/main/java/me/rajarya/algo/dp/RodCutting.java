package me.rajarya.algo.dp;

import java.util.Arrays;

/**
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if the length of the rod is 8 and the values of different pieces are given as the following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * prices: 1   5   8   9  10  17  17  20
 */

public class RodCutting {
    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int N = 4;
        try {
            int maxPrice = solve(prices, N);
            System.out.println(maxPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int solve(int[] prices, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], prices[j-1] + dp[i-j]);
            }
        }
        return dp[n];
    }
}
