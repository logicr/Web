package club.logicr.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jan on 2018/7/13.
 * @version 1.0
 * 使用注解
 */
@Configuration
public class AnnotationExample {
    @Bean
    public String hello(){
        return "hello Jan";
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationExample.class);
        String hello = context.getBean(String.class);
        System.out.println(hello);
    }
}
