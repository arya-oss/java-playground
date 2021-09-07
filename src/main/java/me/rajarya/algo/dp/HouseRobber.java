package me.rajarya.algo.dp;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,1,1,9}; //output = 12
        int ans = solve(nums);
        System.out.println(ans);
    }

    private static int solve(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
       return dp[nums.length-1];
    }

    private static int solveUtil(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (start == end) return nums[start];
        return Math.max(nums[start] + solveUtil(nums, start + 2, end),
                nums[start+1] + solveUtil(nums, start+3, end));
    }
}
