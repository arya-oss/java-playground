package me.rajarya.ds.tree;

public class LeftView {
    static int maxLevel = 0;

    static void levelOrderUtil(Node root, int level) {
        if (root == null) return;
        if (level > maxLevel) {
            System.out.print(" " + root.data);
            maxLevel = level;
        }
        levelOrderUtil(root.left, level + 1);
        levelOrderUtil(root.right, level + 1);
    }

    static void leftView(Node root) {
        levelOrderUtil(root, 1);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.right = new Node(4);
        root.right.left = new Node(3);
        root.right.right = new Node(7);
        leftView(root);
    }
}
