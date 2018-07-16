package club.logicr.springcore.spel;


import java.util.Map;
import java.util.Properties;

/**
 * @author Jan on 2018/7/16.
 * @version 1.0
 */
public class SpelInnerValue {
    public static void main(String[] args) {
     Properties properties = System.getProperties();
        for (Object obj  : properties.keySet()) {
            System.out.println(obj);
        }

      Map<String,String> env =  System.getenv();
        for (String s : env.keySet()) {
            System.out.println(s);
        }
    }
}
