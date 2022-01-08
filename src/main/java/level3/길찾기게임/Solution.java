package level3.길찾기게임;

import java.util.ArrayList;

public class Solution {
    static int[][] answer;
    static int preIndex = 0;
    static int postIndex = 0;

    public static int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];

        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        list.sort((o1, o2) -> {
            if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
            else
                return Integer.compare(o2.y, o1.y);
        });

        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            tree.add(node);
        }

        tree.preOrder(tree.root);
        tree.postOrder(tree.root);
        return answer;
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
            this.root = null;
        }

        void add(Node node) {
            root = addRecursive(root, node);
        }

        Node addRecursive(Node currentNode, Node node) {
            if (currentNode == null) {
                return node;
            }
            if (node.x < currentNode.x) {
                currentNode.left = addRecursive(currentNode.left, node);
            } else if (node.x > currentNode.x) {
                currentNode.right = addRecursive(currentNode.right, node);
            }

            return currentNode;
        }

        public void preOrder(Node node) {
            if (node == null) return;
            answer[0][preIndex++] = node.value;
            preOrder(node.left);
            preOrder(node.right);
        }

        public void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            answer[1][postIndex++] = node.value;

        }
    }

    static class Node {
        int x, y, value;
        Node left, right;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
}
