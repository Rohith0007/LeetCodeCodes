import java.util.Stack;
public class Invert_Binary_Tree_226 {
    public static void main(String[] args) {
        Invert_Binary_Tree_226 ib = new Invert_Binary_Tree_226();
        TreeNode tn = new TreeNode(2);
        tn.left = new TreeNode(1);
        tn.right = new TreeNode(3);
        ib.invertTree(tn);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}


