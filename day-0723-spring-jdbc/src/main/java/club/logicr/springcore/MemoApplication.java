package club.logicr.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 */
public class MemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml"
        );
        Memo memo = (Memo) context.getBean("memo");
//        memo.addMemoGroup();
//        memo.deleteMemoGroup();
//        memo.updateMemoGroup();
        memo.queryGroup();
    }
}
