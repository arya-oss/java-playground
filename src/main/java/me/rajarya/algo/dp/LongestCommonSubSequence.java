package me.rajarya.algo.dp;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 */

public class LongestCommonSubSequence {

    public static int solve(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int lookup[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lookup[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    lookup[i][j] = 1 + lookup[i-1][j-1];
                } else {
                    lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
                }
            }
        }
        return lookup[m][n];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAC";
        String s2 = "GXTXAYC";
        System.out.println(solve(s1, s2));
    }
}
