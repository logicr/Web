package queue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 两个栈实现一个队列
 * 编译通过
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
    }
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        int tmp = 0;
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new EmptyStackException();
        }
        if (!stack2.isEmpty()) {
            tmp = stack2.pop();
        } else if (!stack1.isEmpty() || stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.peek());
                stack1.pop();
            }
            tmp = stack2.pop();
        }
        return tmp;
    }
}