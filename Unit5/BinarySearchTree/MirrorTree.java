package Unit5.BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {
    public TreeNode mirrorBST(TreeNode root) {
        // Write your code here

        return root;
    }
}

public class MirrorTree {
    public static void main(String[] args) {

        /*
         * Original BST:
         * 8
         * / \
         * 4 12
         * / \ / \
         * 2 6 10 14
         */

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        preOrder(root);
        System.out.println();

        Solution sol = new Solution();

        TreeNode mirroredRoot = sol.mirrorBST(root);

        preOrder(root);
        System.out.println();
        preOrder(mirroredRoot);
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
