package club.logicr.springcoretest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 */
public class SpringTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                ""
        )
    }
}
