package me.rajarya.algo.recursion;

public class AllPermutation {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd'};
        permute(arr, 0, arr.length-1);
    }

    private static void permute(char[] arr, int low, int high) {
        if (low == high) {
            System.out.println(arr);
            return;
        }
        for (int i = low; i <= high; i++) {
            swap(arr, low, i);
            permute(arr, low+1, high);
            swap(arr, low, i);
        }
    }
    private static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
