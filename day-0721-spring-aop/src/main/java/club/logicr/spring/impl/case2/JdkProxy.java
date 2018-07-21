package club.logicr.spring.impl.case2;

import club.logicr.spring.PayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
public class JdkProxy {
    public static void main(String[] args) {
//        1
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml"
        );
//        2
        PasyServiceJDKInvocationHandle hander = (PasyServiceJDKInvocationHandle) context.getBean(
                "pasyServiceJDKInvocationHandle"
        );
//        3
        PayService alipayService = (PayService) context.getBean("alipayService");
//        4    ？这里这个是怎么用的？
        PayService payService = (PayService)    Proxy.newProxyInstance(
                alipayService.getClass().getClassLoader(),
                new Class[]{
                        PayService.class
                }, hander
        );
        payService.pay();
//        alipayService.pay();
    }
}
