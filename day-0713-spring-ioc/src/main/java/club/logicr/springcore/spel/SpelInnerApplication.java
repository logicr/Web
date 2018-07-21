package club.logicr.springcore.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jan on 2018/7/16.
 * @version 1.0
 */
public class SpelInnerApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//        SpelInnerBean spelInnerBean = (SpelInnerBean) context.getBean("spelInnerBean");
//        System.out.println(spelInnerBean);
//        MyDataSource myDataSource = (MyDataSource) context.getBean("myDataSource");
        SubMyData myDataSource = (SubMyData) context.getBean("subMyData");
        System.out.println(myDataSource);
    }

}
