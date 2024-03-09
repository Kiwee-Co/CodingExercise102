package exercise.coding102.kiwee.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import exercise.coding102.kiwee.shared.datastructure.TreeNode;

class TreeTest {

    private TreeNode<String> root = Trees.getDefaultTree();

    @Test
    void testDFS() {
        assertFalse(dfs(root, "left -> left -> right"));
        assertTrue(dfs(root, "left -> right"));
        assertTrue(dfs(root, "right -> left -> right"));
        assertTrue(dfs(root, "left -> left -> right"));
    }

    @Test
    void testBFS() {
        assertFalse(bfs(root, "left -> left -> right"));
        assertTrue(bfs(root, "left -> right"));
        assertTrue(bfs(root, "left -> left -> right"));
    }
    
    public <T> boolean dfs(TreeNode<T> root, T data) {
        if (root == null) {
            return false;
        }

        if (root.getData().equals(data)) {
            return true; 
        }

        if (dfs(root.getLeft(), data)) {
            return false;
        }

        return dfs(root.getRight(), data); 
    }
 
    public <T> boolean bfs(TreeNode<T> root, T data) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove();

            if (!currentNode.getData().equals(data)) {
                return false;
            }

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

        return true;
    }    
}
