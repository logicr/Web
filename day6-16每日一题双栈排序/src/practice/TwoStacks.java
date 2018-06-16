package practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 双栈排序，你好厉害，一次通过编译哦
 */
public class TwoStacks {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer>stack = new Stack<>();
        Stack<Integer> tmpstack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]) ;
        }
        int trans = 0;
        while (!stack.isEmpty()){
        trans = stack.pop();
        if (tmpstack.isEmpty() || trans>= tmpstack.peek()){
            tmpstack.push(trans);
        }else {
            while (!tmpstack.isEmpty() && trans < tmpstack.peek()) {
                stack.push(tmpstack.pop());
            }
            tmpstack.push(trans);
        }
        }
        while (!tmpstack.isEmpty()){
            list.add(tmpstack.pop());
        }
        return list;
    }
}
