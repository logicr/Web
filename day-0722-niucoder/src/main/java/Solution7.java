import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jan on 2018/7/28.
 * @version 1.0
 */
public class Solution7 {
    public static void main(String[] args) {
//        String str = "dog. am i";
        String str = " ";
//        if (str == " "){
//            System.out.println(" ");
//            return;
//        }
        if (str.trim().equals(" ")){
            System.out.println(" ");
            return;
        }
        String [] strArray = str.split(" ");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strArray.length; i++) {
            stack.push(strArray[i]);
        }
        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                ret.append(stack.pop());
            } else {
                ret.append(stack.pop()+" ");
            }

        }
        System.out.println(ret.toString());
    }
}
