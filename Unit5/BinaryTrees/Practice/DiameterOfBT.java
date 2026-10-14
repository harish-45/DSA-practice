package Unit5.BinaryTrees.Practice;

public class DiameterOfBT {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        // create a binary tree
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root));

    }

    static int diameter(Node root) {
        if (root == null)
            return 0;

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int selfDiameter = lh + rh + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));

    }
}
