package exercise.coding102.kiwee.trees;

import exercise.coding102.kiwee.shared.datastructure.TreeNode;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode<String> node = TreeNode.createBalancedTree(3);
        
        System.out.println("In-order traversal");
        inOrderTraversal(node);
        
        System.out.println("Post-order traversal");
        postOrderTraversal(node);
        
        System.out.println("Pre-order traversal");
        preOrderTraversal(node);
    }
    
    public static void inOrderTraversal(TreeNode<String> root) {
        if (root != null) {
            inOrderTraversal(root.getLeft());
            System.out.println(root.getData()); // Process the data here
            inOrderTraversal(root.getRight());
        }
    }
    
    public static void postOrderTraversal(TreeNode<String> root) {
        if (root != null) {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.println(root.getData()); // Process the data here
        }
    }
    
    public static void preOrderTraversal(TreeNode<String> root) {
        if (root != null) {
            System.out.println(root.getData()); // Process the data here
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }
}
