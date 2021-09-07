package me.rajarya.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/maximum-time-required-for-all-patients-to-get-infected/
 */

public class InfectedPerson {
    public static void main(String[] args) {
        int arr[][] = {{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
        int m = 3;
        int n = 5;
        int maxTime = solve(arr, m, n);
        System.out.println(maxTime);
    }

    private static boolean isValid(int i, int j, int m, int n, boolean[][] visited, int[][] arr) {
        return i >= 0 && i < m && j >=0 && j < n && !visited[i][j] && arr[i][j] == 1;
    }

    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Tuple {
        int first;
        int second;
        int third;
        public Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    private static int solve(int[][] arr, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int uninfectedCount = 0;
        int time = 0;
        Queue<Tuple> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    queue.offer(new Tuple(i, j, 0));
                    visited[i][j] = true;
                }
                if (arr[i][j] == 1) {
                    uninfectedCount++;
                }
            }
        }
        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
            time = curr.third;
            for(int i=0; i < 4; i++) {
                int ni = curr.first + direction[i][0];
                int nj = curr.second + direction[i][1];
                if (isValid(ni, nj, m, n, visited, arr)) {
                    queue.offer(new Tuple(ni, nj, time + 1));
                    visited[ni][nj] = true;
                    uninfectedCount--;
                }
            }
        }
        if (uninfectedCount != 0) return -1;
        return time;
    }
}
