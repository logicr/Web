package question;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断是不是对称二叉树
 * 通过量90%
 * 不能处理元素全部一样的情况。
 */
public class SolutionNew {
    Queue<String> queue = new LinkedList();
    Stack<String> stack = new Stack<>();
    boolean isSymmetrical(TreeNode pRoot){
        _isSymmetrical(pRoot,stack,queue);
        while (!queue.isEmpty()){
            /*
            equals不能入null
             */
            if(null !=stack.peek()) {
                if (!queue.poll().equals(stack.pop())) {
                    return false;
                }
            }else if (null != queue.peek()){
                return false;
            }
        }
        return true;
    }

    void _isSymmetrical(TreeNode pRoot,Stack<String> stack,Queue<String> queue)
    {
        if(null == pRoot){
            return ;
        }
        stack.push(""+pRoot.val);
        queue.offer(""+pRoot.val);
        _isSymmetrical(pRoot.left,stack,queue);
        _isSymmetrical(pRoot.right,stack,queue);
    }
}
