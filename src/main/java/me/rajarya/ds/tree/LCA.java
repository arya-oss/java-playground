package me.rajarya.ds.tree;

/**
 * Least common ancestor of two nodes in a binary tree
 */
public class LCA {

    public static Node LCA(Node root, Node n1, Node n2) {
        if (null == root) return null;
        if (root == n1) {
            return root;
        }
        if (root == n2) {
            return root;
        }

        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        if (null != leftLCA && null != rightLCA) {
            return root;
        }

        return (null != leftLCA) ? leftLCA: rightLCA;
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        Node n1 = new Node(6);
        Node n2 = new Node(11);
        root.left = new Node(8);
        root.right = new Node(15);
        root.left.right = n1;
        root.left.right.left = new Node(1);
        root.right.left = n2;
        root.right.left.right = new Node(17);

        Node lca = LCA(root, n1, n2);

        System.out.println(lca);

    }
}