import java.util.Scanner;
import java.util.Stack;

/**
 * @author Jan on 2018/7/24.
 * @version 1.0
 */
public class Solution3 {
    /**
     * ]在字符串中找出连续最长的数字串
     * 学到一种思想
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //abcd12345ed125ss123058789
        while (scanner.hasNext()) {
            StringBuilder ret = new StringBuilder();
            char[] str = scanner.next().toCharArray();
            for (char c : str) {
                if ('0' <= c && c <= '9') {
                    ret.append(c);
                } else {
                    ret.append("c");
                }
            }
//            System.out.println(ret.toString());
            String[] strret = ret.toString().split("c");
            int length = 0;
            for (String s : strret) {
                if (s.length() >= length) {
                    length = s.length();
                }
            }
            for (String s : strret) {
                if (s.length() == length) {
                    System.out.print(s);
                }
            }
            System.out.println("," + length);
        }
    }
}