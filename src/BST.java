/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class BST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        printInorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    void printInorder(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;
        printInorder(node.left, list);
        list.add(node.val);
        printInorder(node.right, list);
    }
}