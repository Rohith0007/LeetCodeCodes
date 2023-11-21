import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
class LevelOrder {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrder(tree));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        List<Integer> t = new ArrayList<>();
        List<TreeNode> tempList = new ArrayList<>();
        tempList.add(root);
        List<TreeNode> temp = new ArrayList<>(tempList);
        for (TreeNode tn : tempList) {
            if(tn != null) {
                t.add(tn.val);
            }
        }
        res.add(t);
        t = new ArrayList<>();

        while(tempList.size() != 0) {
            tempList = new ArrayList<>();
            while (temp.size() != 0) {
                TreeNode ln = new TreeNode();
                ln = temp.remove(0);
                if(ln != null) {
                    if(ln.left != null) {
                        tempList.add(ln.left);
                    }
                    if(ln.right != null) {
                        tempList.add(ln.right);
                    }
                }
            }
            for (TreeNode tn : tempList) {
                if(tn != null) {
                    t.add(tn.val);
                }
            }
            temp = tempList;
            res.add(t);
            t = new ArrayList<>();
        }

        res.remove(res.size()-1);
        return res;
    }
}