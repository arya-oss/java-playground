package me.rajarya.sorting;

public class SelectionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minValue = arr[i];
            int minPos = i;
            int j = i;
            while (j < n) {
                if (minValue > arr[j]) {
                    minPos = j;
                    minValue = arr[j];
                }
                j++;
            }
            if(minPos != i) {
                int _temp = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = _temp;
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
