package me.rajarya.algo.dp;

public class FencePainting {
    public static void main(String[] args) {
        int n = 3; // No. of poles
        int k = 2; // No. of paints
        // count no. of ways poles can be painted so that adjacent poles are not of same color.
        int ans = solve(n, k);
        System.out.println(ans);
    }

    private static int solve(int n, int k) {
        int total = k;
        int diff = k, same = 0;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }
}
