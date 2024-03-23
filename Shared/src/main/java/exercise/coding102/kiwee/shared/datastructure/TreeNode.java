package exercise.coding102.kiwee.shared.datastructure;

import java.util.LinkedList;

public class TreeNode<T> {

    private T data;

    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T root) {
        this.data = root;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode<T> withLeft(TreeNode<T> left) {
        setLeft(left);
        return left;
    }

    public TreeNode<T> withLeft(T left) {
        return withLeft(new TreeNode<>(left));
    }

    public TreeNode<T> withRight(TreeNode<T> right) {
        this.setRight(right);
        return right;
    }

    public TreeNode<T> withRight(T right) {
        return withRight(new TreeNode<>(right));
    }

    public T getData() {
        return data;
    }

    public String toString() {
        return data.toString();
    }
    
    public static TreeNode<String> createBalancedTree(int levels) {
        if (levels <= 0) {
            return null;
        }

        var root = new TreeNode<>("root");

        if( levels ==1) {
            return root;
        }
        
        var currentLevel = 1;
        var queue = new LinkedList<TreeNode<String>>();
        var levelQueue = new LinkedList<TreeNode<String>>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var node = queue.pop();
            
            levelQueue.add(node.withLeft(node.getData() + " -> L"));
            levelQueue.add(node.withRight(node.getData() + " -> R"));
            
            if (queue.isEmpty() && !levelQueue.isEmpty() && currentLevel < levels-1) {
                queue = levelQueue;
                levelQueue = new LinkedList<TreeNode<String>>();
                currentLevel++;
            }
        }

        return root;
    }

}
