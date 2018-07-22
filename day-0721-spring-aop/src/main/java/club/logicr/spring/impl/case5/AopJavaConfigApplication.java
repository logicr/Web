package club.logicr.spring.impl.case5;

import club.logicr.spring.PayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Jan on 2018/7/22.
 * @version 1.0
 */
@Configuration

@ComponentScan(basePackages = "club.logicr.spring.impl.case5")
@EnableAspectJAutoProxy
public class AopJavaConfigApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                AopJavaConfigApplication.class
        );
        PayService payService = (PayService) context.getBean("weixinPayService");
        payService.pay();
    }
}
