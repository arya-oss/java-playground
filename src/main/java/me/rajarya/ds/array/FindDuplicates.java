package me.rajarya.ds.array;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 4, 4, 5};
        solve(arr, arr.length);
    }

    private static void solve(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            if (arr[Math.abs(arr[i])] < 0) {
                System.out.println("Duplicates: " + arr[i]);
            } else{
                arr[Math.abs(arr[i])] *= -1;
            }
        }
    }
}
