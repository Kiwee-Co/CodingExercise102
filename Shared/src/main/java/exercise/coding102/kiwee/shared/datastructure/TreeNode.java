package exercise.coding102.kiwee.shared.datastructure;

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
}
