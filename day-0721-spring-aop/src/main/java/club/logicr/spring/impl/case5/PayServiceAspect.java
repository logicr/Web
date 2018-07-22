package club.logicr.spring.impl.case5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Jan on 2018/7/22.
 * @version 1.0
 */
@Aspect
public class PayServiceAspect {
    @Pointcut(value = "execution( * club.logicr.spring.PayService.pay())")
    public void payPointCut(){}

    @Before(value = "payPointCut()")
    public void beforeLog(){
        System.out.println("log");
    }

    @Before(value = "payPointCut()")
    public void beforeSecurity(){
        System.out.println("security");
    }

    @Before(value = "payPointCut()")
    public void beforeTime(){
        System.out.println("before");
    }
    @After(value = "payPointCut()")
    public void afterTime(){
        System.out.println("after");
    }
    @Around(value = "payPointCut()")
    public Object arounTime(ProceedingJoinPoint joinPoint){
        System.out.println("aroundBefor()");
        Object retVal = null;
        try {
            retVal = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("aroundafter()");
        return  retVal;
    }
    @AfterReturning(value = "payPointCut()")
    public void afterReturning(){
        System.out.println("afterReturn");
    }
    @AfterThrowing(value = "payPointCut()",throwing = "e")
    public void throwing(RuntimeException e){
        System.out.println("after throwing" + e.getMessage());
    }

}
