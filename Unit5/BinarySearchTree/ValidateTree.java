package Unit5.BinarySearchTree;

public class ValidateTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static boolean isValidTree(Node root) {
        return isValidTree(root, null, null);
    }

    public static boolean isValidTree(Node root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.data <= min) || (max != null && root.data >= max)) {
            return false;
        }

        return isValidTree(root.left, min, root.data) && isValidTree(root.right, root.data, max);
    }

    public static void main(String[] args) {

        /*
         * 8
         * / \
         * 4 12
         * / \ / \
         * 2 8 10 14
         */

        // BST representation
        Node root = new Node(8);

        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(8);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        boolean result = isValidTree(root);
        System.out.println(result);
    }
}
