package me.rajarya.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 0, -1, 8, 9, 3, -4, 7, 5};
        sort(arr);
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high; j++) {
            if(arr[j] < pivot) {
                i++;
                int _t = arr[i];
                arr[i] = arr[j];
                arr[j] = _t;
            }
        }
        arr[high] = arr[i+1];
        arr[i+1] = pivot;
        return i+1;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (high > low) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
}
