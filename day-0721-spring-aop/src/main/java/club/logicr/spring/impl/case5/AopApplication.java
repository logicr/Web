package club.logicr.spring.impl.case5;

import club.logicr.spring.PayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jan on 2018/7/22.
 * @version 1.0
 */
//通过javaConfig注解配置
public class AopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-aspect.xml"
        );
        PayService payService = (PayService) context.getBean("alipayService");
        payService.pay();
    }
}
