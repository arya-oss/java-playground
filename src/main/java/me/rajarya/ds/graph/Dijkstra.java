package me.rajarya.ds.graph;

import java.util.LinkedList;
import java.util.List;

public class Dijkstra {

    private static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static class TableNode {
        int prev;
        int weight;
        boolean visited;

        public TableNode(int prev, int weight, boolean visited) {
            this.prev = prev;
            this.weight = weight;
            this.visited = visited;
        }

        @Override
        public String toString() {
            return prev + " " + weight + " " + visited;
        }
    }

    public static void main(String[] args) {
        int V = 7;
        List<List<Node>> graph = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new LinkedList<>());
        }
        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(3, 1));
        graph.get(1).add(new Node(4, 10));
        graph.get(2).add(new Node(0, 4));
        graph.get(2).add(new Node(5, 5));
        graph.get(3).add(new Node(2, 2));
        graph.get(3).add(new Node(4, 2));
        graph.get(3).add(new Node(5, 8));
        graph.get(3).add(new Node(6, 4));
        graph.get(4).add(new Node(6, 6));
        graph.get(6).add(new Node(5, 1));

        TableNode[] table = new TableNode[V];
        for (int i = 0; i < V; i++) {
            table[i] = new TableNode(i, Integer.MAX_VALUE, false);
        }
        dijkstra(V, graph, 0, table);
    }

    private static void dijkstra(int V, List<List<Node>> graph, int start, TableNode[] table) {
        table[start].weight = 0;

        for (int c = 0; c < V; c++) {
            int curr = minDistance(V, table);
            if (curr == Integer.MIN_VALUE) break;
            table[curr].visited = true;
            for (Node node : graph.get(curr)) {
                if (!table[node.dest].visited && node.weight + table[curr].weight < table[node.dest].weight) {
                    table[node.dest].weight = node.weight + table[curr].weight;
                    table[node.dest].prev = curr;
                }
            }
        }
    }

    private static int minDistance(int V, TableNode[] table) {
        int minIndex = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if (!table[i].visited && table[i].weight < minValue) {
                minIndex = i;
                minValue = table[i].weight;
            }
        }
        return minIndex;
    }
}
