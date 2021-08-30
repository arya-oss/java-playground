package me.rajarya.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static void levelOrderUtil(Node root, int level, int ht) {
        if (root == null) return;
        if (level == ht)
        System.out.print(" " + root.data);
        
        levelOrderUtil(root.left, level + 1, ht);
        levelOrderUtil(root.right, level + 1, ht);
    }

    static void levelOrder(Node root) {
        int htValue = height(root);
        for (int i = htValue; i >= 0; i--) {
            System.out.println();
            levelOrderUtil(root, i, htValue);
        }
        /* Iterative approach */
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(" " + curr);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(7);
        root.left.right = new Node(6);
        root.left.right.left = new Node(2);
        root.right.left = new Node(3);
        levelOrder(root);
    }
}
