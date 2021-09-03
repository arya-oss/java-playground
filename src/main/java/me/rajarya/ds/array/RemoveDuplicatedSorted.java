package me.rajarya.ds.array;

public class RemoveDuplicatedSorted {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = solve(arr, arr.length);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int solve(int[] arr, int length) {
        int k = 0;
        for (int i = 0; i < length-1; i++) {
            if(arr[i] != arr[i+1]) {
                arr[k++] = arr[i];
            }
        }
        arr[k++] = arr[length-1];
        return k;
    }
}
