package club.logicr.spring.impl.case3;

import club.logicr.spring.component.LogComponent;
import club.logicr.spring.component.SecurityComponent;
import club.logicr.spring.component.TimeComponent;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
public class PayServiceCglibProxy implements MethodInterceptor {
    private final  Object target;
    private final LogComponent logComponent;
    private final SecurityComponent securityComponent;
    private  final TimeComponent timeComponent;

    public PayServiceCglibProxy(Object target, LogComponent logComponent, SecurityComponent securityComponent, TimeComponent timeComponent) {
        this.target = target;
        this.logComponent = logComponent;
        this.securityComponent = securityComponent;
        this.timeComponent = timeComponent;
    }

    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        securityComponent.security();
        logComponent.log();
        long start = timeComponent.startTime();
        Object retVal = methodProxy.invoke(target, objects);
        long end = timeComponent.endTime();
        System.out.println(timeComponent.comute(start,end));
        return retVal;
    }
}
