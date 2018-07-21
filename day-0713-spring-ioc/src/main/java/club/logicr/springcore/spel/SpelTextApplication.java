package club.logicr.springcore.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;


/**
 * @author Jan on 2018/7/16.
 * @version 1.0
 */
public class SpelTextApplication {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        String helloJan = (String) parser.parseExpression("'helloJan'").getValue();
        System.out.println(helloJan);
        String helloJan1 = (String) parser.parseExpression("'helloJan'").getValue(String.class);
        System.out.println(helloJan1);
        methodParse();


    }
    public static void methodParse(){
        ExpressionParser parser = new SpelExpressionParser();
//        String
        String subValue = (String) parser.parseExpression("'Spring Spel'.substring(7)").getValue();
        System.out.println(subValue);
        Integer indexValue = (Integer) parser.parseExpression("'HelloJan'.indexOf('Ja')").getValue();
        System.out.println(indexValue);
//        静态方法
        long currentTimeMillis = parser.parseExpression("T(java.lang.System).currentTimeMillis()").getValue(long.class);
        System.out.println(currentTimeMillis);
//        实例方法
        EvaluationContext context = new StandardEvaluationContext(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String strValue = parser.parseExpression("format(new java.util.Date())")
                .getValue(context, String.class);
        System.out.println(strValue);

    }
}
