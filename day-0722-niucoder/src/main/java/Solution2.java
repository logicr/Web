import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String fir = scanner.next();
            String sec = scanner.next();
            BigInteger biffir = new BigInteger(fir);
            BigInteger bigsec = new BigInteger(sec).add(biffir);
            System.out.println(bigsec);
        }
    }
}
