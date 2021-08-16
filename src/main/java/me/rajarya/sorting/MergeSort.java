package me.rajarya.sorting;

public class MergeSort {

    private static void mergeSort(int[] arr, int low, int high) {
        if (high > low) {
            int mid = (low + high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int j = mid+1;
        if(arr[mid]  < arr[j]) return;
        while (low <= mid && j <= high) {
            if (arr[low] <= arr[j]) low++;
            else {
                int value = arr[j];
                int index = j;
                while (index != low) {
                    arr[index] = arr[--index];
                }
                arr[low] = value;
                low++;
                j++;
                mid++;
            }
        }
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, -1, 8, 9, 3, -4, 7, 5};
        sort(arr);
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
