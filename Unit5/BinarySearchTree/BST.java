package Unit5.BinarySearchTree;

public class BST {

    /**
     * Node
     */
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(int[] values) {
        if (values.length == 0) {
            return null;
        }
        Node root = null;

        for (int val : values) {
            root = buildTree(root, val);
        }

        return root;
    }

    public static Node buildTree(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = buildTree(root.left, data);
        } else {
            root.right = buildTree(root.right, data);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] values = { 4, 2, 7 };
        Node root = buildTree(values);
        inOrder(root);
    }
}
