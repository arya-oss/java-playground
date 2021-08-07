package me.rajarya.sorting;

public class InsertionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int elem = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > elem) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = elem;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, -1, 8, 9, 3, -4, 7, 5};
        sort(arr);
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
