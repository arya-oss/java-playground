package me.rajarya.ds.array;

import java.util.Arrays;

/**
 * Calculate product of array except current item
 *
 * e.g
 * arr = [2, 4, 7, 5]
 * output = [140, 70, 40, 56]
 */

public class CalculateProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 5};
        int[] ans = solve(arr, arr.length);
        for(int i: ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] solve(int[] arr, int length) {
        int[] output = new int[length];
        Arrays.fill(output, 1);

        for (int i = 1; i < length; i++) {
            output[i] = output[i-1] * arr[i-1];
        }
        // [1, 2, 8, 56]
        int mul = arr[length-1];
        for (int i = length-2; i >=0; i--) {
            output[i] *= mul;
            mul *= arr[i];
        }

        return output;
    }
}
