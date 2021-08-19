package me.rajarya.ds.tree;

public class CheckBST {

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        System.out.println(isBST(root));
    }

    private static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node root, int minValue, int maxValue) {
        if (null == root) return true;
        if (minValue > root.data || maxValue < root.data) return false;
        return isBSTUtil(root.left, minValue, root.data-1) && isBSTUtil(root.right, root.data+1, maxValue);
    }
}
