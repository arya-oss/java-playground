package me.rajarya.ds.tree;

public class HeightOfTree {

    static int height(Node root) {
        return null == root ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(7);
        root.left.right = new Node(8);
        root.left.right.left = new Node(3);
        root.right = new Node(5);
        root.right.left = new Node(3);

        assert 4 == height(root);
    }
}
