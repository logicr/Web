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

    public void sayHello() {
        System.out.println("Hello");
    }
}

class SonOfMy extends MyTest {
    public SonOfMy() {
        System.out.println("son construct");
    }
    {
        System.out.println("son common");
    }
    static {
        System.out.println("son Static ");
    }

    @Override
    public void sayHello() {
        super.sayHello();
    }
}

class Out {
    private String name ;

    /**
     * inner class
     */
    static class Inner {
        public void changeName(String string) {
//            System.out.println(name);
//            Out.this.name = string;
//            name = string;/*/
//            System.out.println(name);
            System.out.println(string);
        }
    }
}
public class MyClassTest {
    public static void main(String[] args) {
        new SonOfMy().sayHello();
//        Out.Inner inner = new Out().new Inner();
//        inner.changeName("Jan");
        Out.Inner inner = new Out.Inner();
        inner.changeName("s");
    }
}
