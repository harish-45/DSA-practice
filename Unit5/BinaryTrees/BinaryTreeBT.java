package Unit5.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBT {
    static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public Node buildTree(int[] nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node root = new Node(nodes[index]);
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return root;
        }

        public void preOrder(Node root) {

            if (root == null) {
                System.out.print("-1 ");
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                if (curr == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    }
                    queue.add(null);
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null)
                        queue.add(curr.left);

                    if (curr.right != null)
                        queue.add(curr.right);

                }
            }
        }

        public int countNode(Node root) {
            if (root == null) {
                return 0;
            }

            int left = countNode(root.left);
            int right = countNode(root.right);

            return 1 + left + right;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        bt.preOrder(root);
        System.out.println();
        bt.inOrder(root);
        System.out.println();
        bt.postOrder(root);
        System.out.println();
        bt.levelOrder(root);

        System.out.println(bt.countNode(root));
    }
}