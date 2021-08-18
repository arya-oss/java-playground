package me.rajarya.sorting;

import java.util.Arrays;

public class HeapSort {

    private static class Heap {
        static void heapify(int[] arr) {
            int size = arr.length;
            for (int i = size/2; i >= 0; i--) {
                percolateUp(arr, arr.length, i);
            }
        }

        private static void percolateDown(int[] arr, int i) {
            int childPos = (i - 1) / 2;
            while (childPos >= 0) {
                if (arr[childPos] < arr[i]) {
                    int _t = arr[i];
                    arr[i] = arr[childPos];
                    arr[childPos] = _t;
                }
                i = childPos;
                childPos = (i - 1) / 2;
            }
        }

        static int[] heapSort(int[] arr) {
            heapify(arr);
            int[] cArr = Arrays.copyOf(arr, arr.length);
            for (int i = 0; i < arr.length; i++) {
                cArr[i] = arr[0];
                arr[0] = arr[arr.length-i-1];
                percolateUp(arr, arr.length - i - 1, 0);
            }
            return cArr;
        }

        private static void percolateUp(int[] arr, int size, int i) {
            int lChildPos = 2 * i + 1;
            int rChildPos = 2 * i + 2;
            int largestPos = i;
            if (lChildPos < size && arr[lChildPos] < arr[largestPos]) {
                largestPos = lChildPos;
            }
            if (rChildPos < size && arr[rChildPos] < arr[largestPos]) {
                largestPos = rChildPos;
            }
            if (largestPos != i) {
                int _temp = arr[i];
                arr[i] = arr[largestPos];
                arr[largestPos] = _temp;
                percolateUp(arr, size, largestPos);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        try {
            int[] sArr = Heap.heapSort(arr);
            for (int elem: sArr) {
                System.out.print(" " + elem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
