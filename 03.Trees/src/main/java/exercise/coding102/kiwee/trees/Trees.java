package exercise.coding102.kiwee.trees;

import java.util.LinkedList;
import java.util.Queue;

import exercise.coding102.kiwee.shared.datastructure.TreeNode;

public class Trees {

    public static void main(String[] args) {
        System.out.println("DFS:");
        Trees.dfsPrint(getDefaultTree());

        System.out.println("BFS:");
        Trees.bfsPrint(getDefaultTree());
    }

    public static <T> void bfsPrint(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove();

            // Print the current node's data
            System.out.println(currentNode.getData());

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

    }

    public static TreeNode<String> getDefaultTree() {

        TreeNode<String> root = new TreeNode<>("root");
        root.withLeft("left").withLeft("left -> left").withLeft("left -> left -> left");
        root.getLeft().withRight("left -> right").withLeft("left -> right -> left");

        root.withRight("right").withRight("right -> right").withRight("right -> right -> right");
        root.getRight().withLeft("right -> left").withRight("right -> left -> right");

        return root;
    }

    public static <T> void dfsPrint(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        // Check if the current node's data matches
        System.out.println(root.getData());

        dfsPrint(root.getLeft());

        dfsPrint(root.getRight());
    }
}
