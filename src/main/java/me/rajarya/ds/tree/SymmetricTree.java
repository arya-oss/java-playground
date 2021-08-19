package me.rajarya.ds.tree;

public class SymmetricTree {

    static boolean isMirror(Node root1, Node root2) {
        if (null == root1 && null == root2) return true;
        if (root1 != null && root2 != null && root1.data == root2.data) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }

    static boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(1);

        System.out.println(isSymmetric(root));
    }
}
