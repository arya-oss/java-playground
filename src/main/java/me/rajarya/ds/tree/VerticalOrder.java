package me.rajarya.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrder {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(7);
        root.left.right = new Node(6);
        root.left.right.left = new Node(2);
        root.right.left = new Node(3);
        verticalOrder(root);
    }

    private static void verticalOrder(Node root) {
        Map<Integer, List<Integer>> order = new TreeMap<>();
        verticalOrderUtil(root, 0, order);
        for (Map.Entry<Integer, List<Integer>> entry : order.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Integer item: entry.getValue()) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    private static void verticalOrderUtil(Node root, int level, Map<Integer, List<Integer>> order) {
        if (null == root) return;
        if (!order.containsKey(level)) {
            order.put(level, new ArrayList<>());
        }
        order.get(level).add(root.data);
        verticalOrderUtil(root.left, level-1, order);
        verticalOrderUtil(root.right, level+1, order);
    }
}
