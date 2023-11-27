import java.util.*;
public class Construct_BT {
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode tn = new TreeNode();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
//        tn.val = preorder[0];
//        search(inorder, tn, false, left, right);
//        right.remove(0);
        helperFun(preorder, inorder, left, right, tn, 0);
        return tn;
    }

    public static void helperFun(int[] preorder, int[] inorder, List<Integer> left, List<Integer> right, TreeNode tn, int i) {
        while(i<inorder.length) {
            int key = preorder[i];
            search(inorder, key, false, left, right);
            i++;
            if(left.size() == 1) {
                tn.left.val = left.get(0);
            } else {
                helperFun(preorder, inorder, left, right, tn, i);
            }
            if(right.size() == 1) {
                tn.right.val = right.get(0);
            } else {
                helperFun(preorder, inorder, left, right, tn, i);
            }
        }
    }

    public static void search(int[] inorder, int key, boolean flag, List<Integer> left, List<Integer> right) {
        left.clear();
        right.clear();
        for (int j : inorder) {
            if (j == key) {
                flag = true;
            }
            if (!flag) {
                left.add(j);
            } else {
                right.add(j);
            }
        }
    }
}
