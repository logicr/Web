package club.logicr.springcore.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


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

    }
}
