package me.rajarya.ds.stack;

import java.util.Stack;

public class NextLargerElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 7, 5};
        int N = arr.length;
        int[] output = solve(arr, N);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i] + " -> " + output[i]);
        }
    }

    private static int[] solve(int[] arr, int n) {
        int[] output = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            if (!st.isEmpty()) {
                while (!st.isEmpty() && arr[i] >= st.peek()) {
                    st.pop();
                }
            }
            output[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return output;
    }
}
