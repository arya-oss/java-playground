package me.rajarya.ds.tree;

public class TreeDiameter {
    static int height(Node root) {
        return null == root ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }

    static int diameter(Node root) {
        if (root == null) return 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int rootDiameter = lHeight + rHeight + 1;
        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);
        return Math.max(rootDiameter, Math.max(lDiameter, rDiameter));
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(7);
        root.left.right = new Node(8);
        root.left.right.left = new Node(3);
        root.right = new Node(5);
        root.right.left = new Node(3);

        System.out.println(diameter(root));
    }
}
