package me.rajarya.ds.graph;

import java.util.*;

public class GraphTraversal {

    static void dfsUtil(List<List<Integer>> graph, boolean[] visited, int v, List<Integer> order) {
        visited[v] = true;
        order.add(v);
        for (int dest: graph.get(v)) {
            if (!visited[dest]) {
                dfsUtil(graph, visited, dest, order);
            }
        }
    }

    static List<Integer> dfs(List<List<Integer>> graph, int V) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsUtil(graph, visited, 0, order);
        return order;
    }

    static List<Integer> bfs(List<List<Integer>> graph, int V) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            order.add(curr);
            for (int dest: graph.get(curr)) {
                if (!visited[dest]) {
                    queue.add(dest);
                }
            }
        }

        return order;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(4);
        graph.get(4).add(3);

        List<Integer> dfsOrder = dfs(graph, V);
        System.out.println("\n DFS: ");
        for (int o: dfsOrder) {
            System.out.print(" " + o);
        }
        System.out.println("\n BFS: ");
        List<Integer> bfsOrder = bfs(graph, V);
        for (int o: bfsOrder) {
            System.out.print(" " + o);
        }
    }
}
