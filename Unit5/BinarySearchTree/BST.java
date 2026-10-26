package Unit5.BinarySearchTree;

import javax.swing.tree.TreeNode;

public class BST {

    /**
     * Node
     */
    public static class Node {
        public int data;
        public Node left;
        public Node right;

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

    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                Node succesor = succesor(root.left);
                root.data = succesor.data;
                root.left = deleteNode(root.left, succesor.data);
            }
        }
        return root;
    }

    public static Node succesor(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void printInRange(Node root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.data <= high && root.data >= low) {
            System.out.print(root.data + " ");
            printInRange(root.left, low, high);
            printInRange(root.right, low, high);
        } else if (root.data > high) {
            printInRange(root.left, low, high);
        } else if (root.data < low) {
            printInRange(root.right, low, high);
        }
    }

    public static void main(String[] args) {
        int[] values1 = { 50, 30, 20, 40, 70, 60, 80, 25 };
        Node root1 = buildTree(values1);
        inOrder(root1);
        System.out.println();

        deleteNode(root1, 30);
        inOrder(root1);
        System.out.println();

        int[] values2 = { 10, 5, 15, 3, 7, 18 };
        Node root2 = buildTree(values2);

        printInRange(root2, 7, 15);
    }
}
