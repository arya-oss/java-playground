package me.rajarya.algo.dp;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * e.g;
 * arr = {3, 34, 4, 12, 5, 2}
 * sum = 9
 * Output: True
 */

public class SubsetSum {

    public static boolean solve(int[] arr, int len, int sum) {
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[len][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        int size = arr.length;
        System.out.println(solve(arr, size, sum));
    }
}
