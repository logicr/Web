package club.logicr.spring.impl.case2;

import club.logicr.spring.PayService;
import club.logicr.spring.component.LogComponent;
import club.logicr.spring.component.SecurityComponent;
import club.logicr.spring.component.TimeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Jan on 2018/7/21.
 * @version 1.0
 */
@Component
//通过实现JDK的InvocationHandler这个接口，通过反射进行代理
public class PasyServiceJDKInvocationHandle implements InvocationHandler {
//    private  Object target;
    @Autowired
    private LogComponent logComponent;
    @Autowired
    private SecurityComponent securityComponent;
    @Autowired
    private TimeComponent timeComponent;
    @Autowired
    @Qualifier(value = "alipayService")
    private PayService payService;

//    public PasyServiceJDKInvocationHandle(Object target) {
//        this.target = target;
//    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        安全检查
        securityComponent.security();
//        日志记录
        logComponent.log();
//        支付开始时间
        long start = timeComponent.startTime();
//        核心支付逻辑，通过反射代理
       Object retVal =  method.invoke(payService,args);
//        支付结束时间
        long end = timeComponent.endTime();
        timeComponent.comute(start,end);
        return retVal;
    }
}
