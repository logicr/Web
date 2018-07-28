import java.util.*;

/**
 * @author Jan on 2018/7/27.
 * @version 1.0
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            char[] ret = string.toCharArray();
            for (int i = 0; i < ret.length; i++) {
                if (string.indexOf(ret[i]) == string.lastIndexOf(ret[i])) {
                    System.out.println(ret[i]);
                    break;
                }
                
            }
        }
        scanner.close();
    }
}