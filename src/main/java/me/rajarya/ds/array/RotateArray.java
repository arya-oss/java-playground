package me.rajarya.ds.array;

public class RotateArray {
    public static void rotateRight(int[] nums) {
        int t = nums[nums.length - 1];
        for (int i = nums.length-1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = t;
    }

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotateRight(nums);
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
    }
}
