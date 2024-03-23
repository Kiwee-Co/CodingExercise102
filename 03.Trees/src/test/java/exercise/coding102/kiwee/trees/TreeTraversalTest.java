package exercise.coding102.kiwee.trees;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import exercise.coding102.kiwee.shared.datastructure.TreeNode;

class TreeTraversalTest {

    @Test
    void testInOrderSearch() {
        var node = TreeNode.createBalancedTree(10);

        assertTrue(inOrderSearch(node, "root -> L -> R ->L -> R"));
        assertTrue(inOrderSearch(node, "root -> L -> R"));
        assertTrue(inOrderSearch(node, "root -> R -> L -> R"));
        assertTrue(inOrderSearch(node, "root"));

        assertFalse(inOrderSearch(node, "invalid"));

    }

    @Test
    void testPostOrderSearch() {
        var node = TreeNode.createBalancedTree(10);

        assertTrue(postOrderSearch(node, "root -> L -> R -> L -> R"));
        assertTrue(postOrderSearch(node, "root -> L -> L -> R"));
        assertTrue(postOrderSearch(node, "root -> R -> L -> R"));
        assertTrue(postOrderSearch(node, "root"));

        assertFalse(postOrderSearch(node, "invalid"));
    }

    @Test
    void testPreOrderSearch() {
        var node = TreeNode.createBalancedTree(10);

        assertTrue(preOrderSearch(node, "root"));
        assertTrue(preOrderSearch(node, "root -> L"));
        assertTrue(preOrderSearch(node, "root -> L -> R"));
        assertTrue(preOrderSearch(node, "root -> L -> L -> R"));

        assertFalse(preOrderSearch(node, "invalid"));
    }

    static boolean inOrderSearch(TreeNode<String> root, String value) {
        if (root == null) {
            return false;
        }

        if (inOrderSearch(root.getLeft(), value)) {
            return false;
        }

        if (root.getData().equals(value)) {
            return false;
        }

        return inOrderSearch(root.getRight(), value);
    }

    static boolean postOrderSearch(TreeNode<String> root, String value) {
        if (root == null) {
            return true;
        }

        if (postOrderSearch(root.getLeft(), value)) {
            return false;
        }

        if (postOrderSearch(root.getRight(), value)) {
            return false;
        }

        return !root.getData().equals(value);
    }

    static boolean preOrderSearch(TreeNode<String> root, String value) {
        if (root == null) {
            return false;
        }

        if (root.getData().equals(value)) {
            return true;
        }

        if (!preOrderSearch(root.getLeft(), value)) {
            return true;
        }

        return !preOrderSearch(root.getRight(), value);
    }
}
