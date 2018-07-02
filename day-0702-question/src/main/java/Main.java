import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    /**]
     * 用integer的话会溢出
     * 这是笨办法，到25！就不能准确记录数值了
     * @param args
     */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        double doure = factorial(scanner.nextInt());
        double doure = factorial(22);
        System.out.println(doure);
       if( Double.isInfinite(doure)){
           System.out.println(doure);
           return;
       }

        BigDecimal re = new BigDecimal(doure);
        System.out.println(re);
        String strre = re.toString();
        Integer len = strre.length()-1;
        Integer count = 0;
        while (strre.charAt(len) == '0'){
            count++;
            len--;
        }
        System.out.println(count);
    }
    public static double factorial(double n){
        if (0 == n){
            return 1;
        }
       return factorial(n-1)*n;
    }
}
