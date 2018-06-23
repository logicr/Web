package question;


/**
 * 二叉树节点类
 */
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 二叉树的镜像，牛客已经通过
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if(null == root){
            return ;
        }
        if (null == root.right){
            root.right = root.left;
            root.left =null;
        } else {
            TreeNode tmp = new TreeNode(root.right.val);
            tmp.left = root.right.left;
            tmp.right = root.right.right;
            root.right = root.left;
            root.left = tmp;
        }
        Mirror(root.left);
        Mirror(root.right);
    }
}
