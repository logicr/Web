package club.logicr.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jan on 2018/7/13.
 * @version 1.0
 * 主类
 */
public class IoCXmlApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml"
        );
        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
        System.out.println(exampleBean);
        ClientService clientService = (ClientService) context.getBean("clientService");
//        System.out.println(clientService);
        DefaultServiceLocator defaultServiceLocator = (DefaultServiceLocator) context.getBean("defaultServiceLocator");
        System.out.println(defaultServiceLocator);
    }
}
