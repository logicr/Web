/**
 * @author Jan on 2019/6/19.
 * @version 1.0
 */
public class MyTest {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        Object object = new String("Hello");
        System.out.println(str1 == str2);
        System.out.println(str3 == str4);
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));
        System.out.println(str1.charAt(2));
        System.out.println(str1.startsWith("h"));
        Integer num1 = new Integer(128);
        Integer num2 = new Integer(128);
        Integer num3 = 1;
        Integer num4 = 1;
        System.out.println(num4 == num3);
    }
}
