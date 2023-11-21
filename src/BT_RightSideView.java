import java.util.ArrayList;
import java.util.List;

public class BT_RightSideView {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4)));
        System.out.println(levelOrder(tree));
    }
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        List<TreeNode> tempList = new ArrayList<>();
        tempList.add(root);
        List<TreeNode> temp = new ArrayList<>(tempList);
        res.add(root.val);

        while(tempList.size() != 0) {
            tempList = new ArrayList<>();
            while (temp.size() != 0) {
                TreeNode ln = new TreeNode();
                ln = temp.remove(0);
                if(ln != null) {
                    if(ln.right != null) {
                        tempList.add(ln.right);
                    } else {
                        if (ln.left != null) {
                            tempList.add(ln.left);
                        }
                    }
                }
            }
            for (TreeNode tn : tempList) {
                if(tn != null) {
                    res.add(tn.val);
                }
            }
            temp = tempList;
        }
        return res;
    }
}
