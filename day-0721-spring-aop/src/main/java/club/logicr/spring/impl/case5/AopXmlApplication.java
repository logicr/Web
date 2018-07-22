package club.logicr.spring.impl.case5;

import club.logicr.spring.PayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jan on 2018/7/22.
 * @version 1.0
 */
public class AopXmlApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-aspect2.xml"
        );
        PayService payService = (PayService) context.getBean("weixinPayService");
        payService.pay();
    }
}
