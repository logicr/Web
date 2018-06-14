package practice;

import java.util.Stack;


/**
 * 辅助栈实现最小栈
 */
public class Solution {
       Stack<Integer> stack = new Stack<>();
       Stack<Integer> tmp = new Stack<>();

    public static void main(String[] args) {
    }

    public void push(int node) {
        stack.push(node);
        if (tmp.isEmpty() || node < tmp.peek()){
            tmp.push(node);
        }else {
            tmp.push(tmp.peek());
        }

    }
    public void pop() {
        if (!stack.isEmpty()&& !tmp. isEmpty()){
            stack.pop();
            tmp.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return tmp.peek();
    }
}
