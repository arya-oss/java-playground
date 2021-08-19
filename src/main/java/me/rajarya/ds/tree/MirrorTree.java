package me.rajarya.ds.tree;

public class MirrorTree {

    static boolean isMirror(Node root1, Node root2) {
        if (null == root1 && null == root2) return true;
        if (root1 != null && root2 != null && root1.data == root2.data) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }

    private static void inOrder(Node root) {
        if (null != root) {
            inOrder(root.left);
            System.out.print(" " + root.data);
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(3);
        root.right.right = new Node(7);
        inOrder(root);
        Node mirrorRoot = buildMirror(root);
        System.out.println();
        inOrder(root);
        System.out.println(isMirror(root, mirrorRoot));

    }

    private static Node buildMirror(Node root) {
        if (null == root) return null;
        Node left = root.left;
        root.left = buildMirror(root.right);
        root.right = buildMirror(left);
        return root;
    }
}
