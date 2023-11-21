public class Construct_BT {
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode res = new TreeNode();
        res.val = preorder[0];
        int ind = findEl(res.val, inorder);
        if(ind != -1) {
            int[] left = new int[ind];
            int[] right = new int[inorder.length - 1];
        }
        return res;
    }

    private static int findEl(int val, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
