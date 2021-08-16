package me.rajarya.ds.graph;

import java.util.*;

public class ToplogicalSort {

    static void topSortUtil(List<List<Integer>> graph, boolean[] visited, int v, Stack<Integer> order) {
        visited[v] = true;
        order.add(v);
        for (int dest: graph.get(v)) {
            if (!visited[dest]) {
                topSortUtil(graph, visited, dest, order);
            }
        }
    }

    static List<Integer> topSort(List<List<Integer>> graph, int V) {
        List<Integer> order = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSortUtil(graph, visited, i, st);
            }
        }
        while (!st.isEmpty()) {
            order.add(st.pop());
        }
        return order;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        List<Integer> topOrder = topSort(graph, V);
        for (int o: topOrder) {
            System.out.print(" " + o);
        }
    }
}
