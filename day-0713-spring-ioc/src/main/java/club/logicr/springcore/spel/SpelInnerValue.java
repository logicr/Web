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
//        for (Object obj  : properties.keySet()) {
        for (Map.Entry<Object,Object> obj  : properties.entrySet()) {
            System.out.println(obj.getKey()+"="+obj.getValue());
        }

      Map<String,String> env =  System.getenv();
//        for (String s : env.keySet()) {
        for (Map.Entry<String,String> s : env.entrySet()) {
            System.out.println(s.getKey()+"="+s.getValue());
        }
    }
}
