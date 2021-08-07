package me.rajarya.sorting;

public class BubbleSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int _temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = _temp;
                }
            }
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
