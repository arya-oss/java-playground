package me.rajarya.algo.dp;

import java.util.Arrays;

/**
 * Problem Statement:
 * Given a value N, if we want to make change for N cents
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 */

public class CoinChange {

    public static int recursiveSolution(int[] coins, int m, int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (m <= 0 && n >= 1) return 0;
        return recursiveSolution(coins, m - 1, n) + recursiveSolution(coins, m, n - coins[m - 1]);
    }

    public static int dpSolution(int[] coins, int m, int n) {
        int lookup[] = new int[n + 1];
        Arrays.fill(lookup, 0);
        lookup[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++) {
                lookup[j] += lookup[j - coins[i]];
            }
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        int value = 4;
        int[] coins = {1, 2, 3};
        System.out.println(recursiveSolution(coins, coins.length, value));
        System.out.println(dpSolution(coins, coins.length, value));
    }
}
