package me.rajarya.algo.dp;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert
 * Remove
 * Replace
 * All the above operations are of equal cost.
 */

public class EditDistance {
    public static int solve(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] lookup = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            lookup[i][0] = i;
        }

        for (int i = 0; i < n; i++) {
            lookup[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1];
                } else {
                    lookup[i][j] = 1 + Math.min(Math.min(lookup[i - 1][j], lookup[i][j - 1]), lookup[i - 1][j - 1]);
                }
            }
        }

        return lookup[m][n];
    }

    public static void main(String[] args) {
        String s1 = "leekcore1";
        String s2 = "leetcode";
        System.out.println(solve(s1, s2));
    }
}
