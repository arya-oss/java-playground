package me.rajarya.ds.array;

public class FindNoneRepeatingInDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 3, 4, 3};
        int expected = 4;
        int result = solve(arr, arr.length);
        assert expected == result;
    }

    private static int solve(int[] arr, int length) {
        int out = arr[0];
        for (int i = 1; i < length; i++) {
            out ^= arr[i];
        }
        return out;
    }
}
