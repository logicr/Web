/**
 * @author Jan on 2019/6/17.
 * @version 1.0
 */
class MyTest {
    public MyTest() {
        System.out.println("construct");
    }
    {
        System.out.println("common");
    }
    static {
        System.out.println("static");
    }
}
public class MyClassTest {
    public static void main(String[] args) {
        new MyTest();
    }
}
