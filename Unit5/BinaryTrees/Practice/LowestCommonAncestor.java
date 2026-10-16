package Unit5.BinaryTrees.Practice;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // create a Binary tree
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

        System.out.println(LCA(root, root.left.right, root.left.left));

    }

    public static int LCA(Node root, Node r1, Node r2) {
        if (root == null) {
            return -1;
        }
        List<Integer> path1 = new ArrayList<>();
        if (!getPath(root, r1, path1)) {
            return -1;
        }

        List<Integer> path2 = new ArrayList<>();
        if (!getPath(root, r2, path2)) {
            return -1;
        }

        int n = Math.min(path1.size(), path2.size());
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (path1.get(i) == path2.get(i)) {
                ans = path1.get(i);
            }
        }

        return ans;
    }

    public static boolean getPath(Node root, Node p, List<Integer> list) {

        if (root == null) {
            return false;
        }

        list.add(root.data);

        if (root.data == p.data) {
            return true;
        }

        boolean ans1 = getPath(root.left, p, list);
        boolean ans2 = getPath(root.right, p, list);

        if (!(ans1 || ans2)) {
            list.removeLast();
            return false;
        } else {
            return true;
        }
    }
}