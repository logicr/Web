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
 * 已经通过了啊
 */
public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        /*
        注意判空啊；
        不要返回null啊null ！= 空ArrayList<ArrayList<Integer>>()；
         */
        if (null == pRoot){
            return new ArrayList<ArrayList<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        queue.offer(pRoot);

        /*
        采用大佬的标记法
         */
        int layer = 1;
        int num = 0;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            layer--;
            /*
            left
             */
            if (null != tmp.left) {
                queue.offer(tmp.left);
                num++;
            }
            /*
            right
             */
            if (null != tmp.right) {
                queue.offer(tmp.right);
                num++;
            }
            if (0 == layer){
                layer = num;
                num =0;
                arrayLists.add(list);
                list = new ArrayList<>();
            }

        }
        return arrayLists;
    }
}