package me.rajarya.algo.dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/s
 */

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int ans = minCostClimbingStairs(cost);
        System.out.println(ans);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int oneStepCost = cost[0];
        int twoStepCost = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = cost[i] + Math.min(oneStepCost, twoStepCost);
            oneStepCost = twoStepCost;
            twoStepCost = temp;
        }
        return Math.min(oneStepCost, twoStepCost);
    }

}
