package question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeNode
 */
class  TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

/**
 * 层序遍历二叉树，并分层
 */
public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            /*
            left
             */
            if (null != tmp.left) {
                queue.offer(tmp.left);
            }
            /*
            right
             */
            if (null != tmp.right) {
                queue.offer(tmp.right);
            }

        }
        return arrayLists;
    }
}