package queue;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {

        int i = 0;
//        String str[] = new String[3];
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()){
            scanner.nextInt()
        String str = scanner.next();
        char []data = str.toCharArray();
        switch (data[0]) {
            case 'A': {
                if (stack.isEmpty()) {
                    System.out.println("E");
                }
                System.out.println(stack.peek());
                ;
            }
            break;
            case 'P': {
                int tmp = data[2] - '0';
                stack.push(tmp);
            }
            break;
            case 'O': {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                break;
            }
            default:
        }
        }
    }
}
