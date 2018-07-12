package club.logicr.spring.xml;

import club.logicr.spring.common.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlApplication {
    public static void main(String[] args) {
        /*映射xml文件*/
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        /*获取对象*/
        XmlShapeCompute xmlShapeCompute = (XmlShapeCompute) context.getBean("xmlShapeCompute");
        Shape shape = xmlShapeCompute.compute("circular");
        Shape shape2 = xmlShapeCompute.compute("rectangle");
        Shape shape3 = xmlShapeCompute.compute("triangle");
        System.out.println(shape);
        System.out.println(shape2);
        System.out.println(shape3);
    }
}
