package me.rajarya.ds.array;

/**
 * Write an efficient program to find the sum of contiguous sub-array within
 * a one-dimensional array of numbers that has the largest sum.
 *
 * arr: [-2, -3, 4, -1, -2, 1, 5, -3]
 * ans: 7
 */
public class MaxSumSubArray {

    public static int largestSumSubArray(int[] arr) {
        int maxHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int elem: arr) {
            maxHere += elem;
            if (maxSoFar < maxHere) {
                maxSoFar = maxHere;
            }
            if (maxHere < 0) {
                maxHere = 0;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(largestSumSubArray(arr));
    }
}
